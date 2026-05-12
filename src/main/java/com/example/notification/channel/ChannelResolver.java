package com.example.notification.channel;

import com.example.notification.template.enums.ChannelType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChannelResolver {

    private final List<NotificationChannel> channels;

    public NotificationChannel resolve(
            ChannelType type
    ) {

        return channels.stream()
                .filter(channel ->
                        channel.getType() == type
                )
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(
                                "Channel not supported"
                        ));
    }
}