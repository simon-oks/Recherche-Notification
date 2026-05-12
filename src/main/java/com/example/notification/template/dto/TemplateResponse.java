package com.example.notification.template.dto;

import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;
import com.example.notification.template.enums.TemplateFormat;

import java.util.List;
import java.util.UUID;

public record TemplateResponse(

        UUID id,

        NotificationCategory category,

        ChannelType channel,

        TemplateFormat format,

        String subject,

        String body,

        List<TemplateVariableResponse> variables

) {
}