package com.example.notification.notif;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @Date 12/05/2026
 */
public interface NotificationRepository
        extends JpaRepository<Notification, UUID> {
}