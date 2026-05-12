package com.example.notification.channel.sms;

import com.example.notification.channel.NotificationChannel;
import com.example.notification.notif.Notification;
import com.example.notification.template.enums.ChannelType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsChannel implements NotificationChannel {

    @Override
    public ChannelType getType() {
        return ChannelType.SMS;
    }

    @Override
    public void send(String recipient, Notification notification) {

        log.info("""
                
                Sending SMS notification
                
                To: {}
                Message: {}
                
                """,
                recipient,
                notification.getBody()
        );
    }
}
