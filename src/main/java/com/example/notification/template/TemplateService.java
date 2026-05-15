package com.example.notification.template;

import com.example.notification.institution.Institution;
import com.example.notification.institution.InstitutionService;
import com.example.notification.template.dto.CreateTemplateRequest;
import com.example.notification.template.dto.CreateTemplateVariableRequest;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.entity.TemplateVariable;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository repository;

    private final InstitutionService institutionService;

    public NotificationTemplate create(
            CreateTemplateRequest request
    ) {

        Institution institution =
                institutionService.findByCode(
                        request.institutionCode()
                );

        NotificationTemplate template =
                new NotificationTemplate();

        template.setInstitution(institution);

        template.setCategory(request.category());

        template.setChannel(request.channel());

        template.setFormat(request.format());

        template.setSubject(request.subject());

        template.setBody(request.body());

        for (CreateTemplateVariableRequest variableRequest
                : request.variables()) {

            TemplateVariable variable =
                    new TemplateVariable();

            variable.setName(variableRequest.name());

            variable.setBusinessType(
                    variableRequest.businessType()
            );

            variable.setRequired(
                    variableRequest.required()
            );

            variable.setTemplate(template);

            template.getVariables().add(variable);
        }

        return repository.save(template);
    }

    public NotificationTemplate find(
            Institution institution,
            NotificationCategory category,
            ChannelType channel
    ) {
        return repository
                .findByInstitutionAndCategoryAndChannel(
                        institution,
                        category,
                        channel
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Template not found"
                        ));
    }

    public NotificationTemplate find(
            String institutionCode,
            NotificationCategory category,
            ChannelType channel
    ) {

        return repository
                .findByInstitution_CodeAndCategoryAndChannel(
                        institutionCode,
                        category,
                        channel
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Template not found"
                        ));
    }
}