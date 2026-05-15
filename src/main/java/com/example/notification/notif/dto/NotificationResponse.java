package com.example.notification.notif.dto;

import com.example.notification.template.enums.NotificationCategory;

import java.util.List;
import java.util.UUID;

public record NotificationResponse(

        UUID id,

        String externalUserId,

        NotificationCategory category,

        List<ChannelNotificationResponse> channelNotifications
) {
}