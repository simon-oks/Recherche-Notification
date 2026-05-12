package com.example.notification.template.mapper;

import com.example.notification.template.dto.TemplateVariableResponse;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.dto.TemplateResponse;
import com.example.notification.template.entity.TemplateVariable;

import java.util.List;

public class TemplateMapper {

    private TemplateMapper() {
    }

    public static TemplateResponse toResponse(
            NotificationTemplate template
    ) {

        List<TemplateVariableResponse> variables =
                template.getVariables()
                        .stream()
                        .map(TemplateMapper::toVariableResponse)
                        .toList();

        return new TemplateResponse(
                template.getId(),
                template.getCategory(),
                template.getChannel(),
                template.getFormat(),
                template.getSubject(),
                template.getBody(),
                variables
        );
    }

    private static TemplateVariableResponse toVariableResponse(
            TemplateVariable variable
    ) {

        return new TemplateVariableResponse(
                variable.getName(),
                variable.getBusinessType(),
                variable.isRequired()
        );
    }
}