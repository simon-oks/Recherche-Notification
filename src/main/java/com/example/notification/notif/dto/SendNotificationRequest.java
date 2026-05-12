package com.example.notification.notif.dto;

import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;

import java.util.Map;

/**
 * @Date 12/05/2026
 */
public record SendNotificationRequest(

        String institutionCode,

        String externalUserId,

        NotificationCategory category,

        ChannelType channel,

        Map<String, Object> variables
) {
}