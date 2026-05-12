package com.example.notification.websocket;

import com.example.notification.notif.Notification;
import com.example.notification.websocket.dto.RealtimeNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public void send(Notification notification) {

        RealtimeNotification payload = new RealtimeNotification(
                notification.getId(),
                notification.getCategory(),
                notification.getChannel(),
                notification.getSubject(),
                notification.getBody(),
                notification.getStatus(),
                notification.getCreatedAt()
        );

        String destination =
                "/topic/users/"
                        + notification.getUser()
                        .getExternalUserId()
                        + "/notifications";

        messagingTemplate.convertAndSend(
                destination,
                payload
        );
        log.info(
                "Sending websocket notification to {}",
                destination
        );
    }
}