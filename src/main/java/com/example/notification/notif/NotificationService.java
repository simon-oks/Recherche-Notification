package com.example.notification.notif;

import com.example.notification.channel.ChannelResolver;
import com.example.notification.channel.NotificationChannel;
import com.example.notification.institution.Institution;
import com.example.notification.institution.InstitutionService;
import com.example.notification.notif.dto.SendNotificationRequest;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.TemplateService;
import com.example.notification.template.renderer.RendererResolver;
import com.example.notification.template.renderer.TemplateRenderer;
import com.example.notification.template.validation.TemplateVariableValidator;
import com.example.notification.user.NotificationUserService;
import com.example.notification.user.entity.NotificationUser;
import com.example.notification.user.entity.UserPreference;
import com.example.notification.user.repository.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final UserPreferenceRepository preferenceRepository;

    private final InstitutionService institutionService;
    private final NotificationUserService userService;
    private final TemplateService templateService;

    private final RendererResolver rendererResolver;
    private final TemplateVariableValidator validator;
    private final ChannelResolver channelResolver;

    public Notification send(
            SendNotificationRequest request
    ) {

        Institution institution =
                institutionService.findByCode(
                        request.institutionCode()
                );

        NotificationTemplate template =
                templateService.find(
                        institution,
                        request.category(),
                        request.channel()
                );

        NotificationUser user =
                userService.find(
                        request.institutionCode(),
                        request.externalUserId()
                );

        UserPreference preference =
                preferenceRepository
                        .findByUserAndChannel(
                                user,
                                request.channel()
                        )
                        .orElse(null);

        if (preference != null
                && !preference.isEnabled()) {

            throw new RuntimeException(
                    "Channel disabled for user"
            );
        }

        final String RECIPIENT = switch (request.channel()) {
            case EMAIL -> user.getEmail();
            case SMS -> user.getPhoneNumber();
            case IN_APP -> user.getExternalUserId();
        };

        Notification notification =
                new Notification();

        notification.setInstitution(institution);
        notification.setTemplate(template);
        notification.setCategory(request.category());
        notification.setChannel(request.channel());
        notification.setUser(user);

        // Validate template variables
        validator.validate(
                template,
                request.variables()
        );

        // Render template
        TemplateRenderer renderer =
                rendererResolver.resolve(
                        template.getFormat()
                );

        String renderedSubject =
                renderer.render(
                        template.getSubject(),
                        request.variables()
                );

        String renderedBody =
                renderer.render(
                        template.getBody(),
                        request.variables()
                );

        notification.setSubject(renderedSubject);
        notification.setBody(renderedBody);

        notification.setStatus(
                NotificationStatus.PENDING
        );

        NotificationChannel channel =
                channelResolver.resolve(
                        notification.getChannel()
                );

        try {
            channel.send(RECIPIENT, notification);

            notification.setStatus(
                    NotificationStatus.SENT
            );

            notification.setSentAt(
                    Instant.now()
            );

        } catch (Exception ex) {
            ex.printStackTrace();
            notification.setStatus(
                    NotificationStatus.FAILED
            );

            notification.setErrorMessage(
                    ex.getMessage()
            );
        }
        return repository.save(notification);
    }
}