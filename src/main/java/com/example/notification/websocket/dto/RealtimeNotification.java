package com.example.notification.websocket.dto;

import com.example.notification.notif.NotificationStatus;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;

import java.time.Instant;
import java.util.UUID;

public record RealtimeNotification(

        UUID id,

        NotificationCategory category,

        ChannelType channel,

        String subject,

        String body,

        NotificationStatus status,

        Instant createdAt

) {
}