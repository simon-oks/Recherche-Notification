package com.example.notification.notif;

import com.example.notification.channel.ChannelResolver;
import com.example.notification.channel.NotificationChannel;
import com.example.notification.institution.InstitutionService;
import com.example.notification.notif.dto.ChannelNotificationResponse;
import com.example.notification.notif.dto.NotificationResponse;
import com.example.notification.notif.dto.SendNotificationRequest;
import com.example.notification.notif.mapper.NotificationMapper;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.TemplateService;
import com.example.notification.template.enums.ChannelType;
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
import java.util.ArrayList;
import java.util.List;

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

    public NotificationResponse send(
            SendNotificationRequest request
    ) {

        NotificationUser user =
                userService.find(
                        request.institutionCode(),
                        request.externalUserId()
                );

        List<UserPreference> preferences = preferenceRepository.findByUserAndEnabledTrue(user);

        Notification notification = new Notification();
        List<ChannelNotificationResponse> channelNotifications = new ArrayList<>();

        // Envoyer la notification sur chaque canal de l'utilisateur
        for (UserPreference preference : preferences) {

            ChannelType channel = preference.getChannel();

            NotificationTemplate template = templateService.find(
                    request.institutionCode(),
                    request.category(),
                    channel
            );

            // Resolve the renderer
            TemplateRenderer renderer = rendererResolver.resolve(template.getFormat());

            // Render the template
            String subject = renderer.render(template.getSubject(), request.variables());
            String body = renderer.render(template.getBody(), request.variables());

            notification.setInstitution(template.getInstitution());
            notification.setUser(user);
            notification.setTemplate(template);
            notification.setCategory(request.category());
            notification.setChannel(channel);
            notification.setSubject(subject);
            notification.setBody(body);
            notification.setStatus(NotificationStatus.PENDING);

            notification = repository.save(notification);

            // Resoudre la canal
            NotificationChannel notificationChannel = channelResolver.resolve(channel);

            String recipient =
                    switch (channel) {
                        case EMAIL -> user.getEmail();
                        case SMS -> user.getPhoneNumber();
                        case IN_APP -> user.getExternalUserId();
                    };

            try {
                notificationChannel.send(recipient, notification);
                notification.setStatus(NotificationStatus.SENT);
                notification.setSentAt(Instant.now());

                channelNotifications.add(new ChannelNotificationResponse(channel, notification.getStatus()));
            } catch (Exception ex) {
                notification.setStatus(NotificationStatus.FAILED);
                notification.setErrorMessage(ex.getMessage());

                channelNotifications.add(new ChannelNotificationResponse(channel, notification.getStatus()));
            }
            notification = repository.save(notification);
        }
        return NotificationMapper.toResponse(notification, channelNotifications);
    }
}