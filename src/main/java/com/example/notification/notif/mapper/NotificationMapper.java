package com.example.notification.notif.mapper;

import com.example.notification.notif.Notification;
import com.example.notification.notif.dto.ChannelNotificationResponse;
import com.example.notification.notif.dto.NotificationResponse;

import java.util.List;

public class NotificationMapper {

    private NotificationMapper() {
    }

    public static NotificationResponse toResponse(
            Notification notification,
            List<ChannelNotificationResponse> channelNotifications
    ) {

        return new NotificationResponse(
                notification.getId(),
                notification.getUser()
                        .getExternalUserId(),
                notification.getCategory(),
                channelNotifications
        );
    }
}