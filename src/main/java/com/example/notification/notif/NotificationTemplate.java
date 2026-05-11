package com.example.notification.notif;

import com.example.notification.institution.Institution;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class NotificationTemplate {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private NotificationCategory category;

    @Enumerated(EnumType.STRING)
    private ChannelType channel;

    private String subject;

    @Lob
    private String body;

    @ManyToOne
    private Institution institution;
}
