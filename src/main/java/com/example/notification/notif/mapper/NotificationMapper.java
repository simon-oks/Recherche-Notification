package com.example.notification.notif.mapper;

import com.example.notification.notif.Notification;
import com.example.notification.notif.dto.NotificationResponse;

public class NotificationMapper {

    private NotificationMapper() {
    }

    public static NotificationResponse toResponse(
            Notification notification
    ) {

        return new NotificationResponse(
                notification.getId(),
                notification.getUser()
                        .getExternalUserId(),
                notification.getCategory(),
                notification.getChannel(),
                notification.getStatus()
        );
    }
}