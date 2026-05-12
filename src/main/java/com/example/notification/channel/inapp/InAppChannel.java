package com.example.notification.channel.inapp;

import com.example.notification.channel.NotificationChannel;
import com.example.notification.notif.Notification;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.websocket.NotificationWebSocketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InAppChannel implements NotificationChannel {

    private final NotificationWebSocketService websocketService;

    @Override
    public ChannelType getType() {
        return ChannelType.IN_APP;
    }

    @Override
    public void send(
            String recipient,
            Notification notification
    ) {
        log.info("IN_APP CHANNEL CALLED");
        websocketService.send(notification);
    }
}