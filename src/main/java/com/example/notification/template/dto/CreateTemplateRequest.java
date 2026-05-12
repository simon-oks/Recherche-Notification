package com.example.notification.template.dto;

import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;
import com.example.notification.template.enums.TemplateFormat;

import java.util.List;

/**
 * @Date 12/05/2026
 */
public record CreateTemplateRequest(

        String institutionCode,

        NotificationCategory category,

        ChannelType channel,

        TemplateFormat format,

        String subject,

        String body,

        List<CreateTemplateVariableRequest> variables

) {
}