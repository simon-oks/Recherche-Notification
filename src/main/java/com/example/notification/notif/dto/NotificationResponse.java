package com.example.notification.notif.dto;

import com.example.notification.notif.NotificationStatus;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;

import java.util.UUID;

public record NotificationResponse(

        UUID id,

        String externalUserId,

        NotificationCategory category,

        ChannelType channel,

        NotificationStatus status

) {
}