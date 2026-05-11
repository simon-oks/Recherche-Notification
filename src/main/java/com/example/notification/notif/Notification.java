package com.example.notification.notif;

import com.example.notification.institution.Institution;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Notification {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private NotificationCategory category;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private String recipient;

    private String subject;

    @Lob
    private String body;

    private Instant createdAt;

    private Instant readAt;

    @ManyToOne
    private Institution institution;
}
