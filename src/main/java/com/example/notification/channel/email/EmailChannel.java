package com.example.notification.channel.email;

import com.example.notification.channel.NotificationChannel;
import com.example.notification.notif.Notification;
import com.example.notification.template.enums.ChannelType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailChannel implements NotificationChannel {

    private final EmailSender sender;

    @Override
    public ChannelType getType() {

        return ChannelType.EMAIL;
    }

    @Override
    public void send(String recipient, Notification notification) {
        sender.sendHtml(
                recipient,
                notification.getSubject(),
                notification.getBody()
        );
    }
}