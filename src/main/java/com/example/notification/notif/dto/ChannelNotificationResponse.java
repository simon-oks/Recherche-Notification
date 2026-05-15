package com.example.notification.notif.dto;

import com.example.notification.notif.NotificationStatus;
import com.example.notification.template.enums.ChannelType;

/**
 * @Date 15/05/2026
 */
public record ChannelNotificationResponse(
        ChannelType channel,
        NotificationStatus status
) {
}
