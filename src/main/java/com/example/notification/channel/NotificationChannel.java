package com.example.notification.channel;

import com.example.notification.notif.Notification;
import com.example.notification.template.enums.ChannelType;

public interface NotificationChannel {

    ChannelType getType();

    void send(String recipient, Notification notification);
}