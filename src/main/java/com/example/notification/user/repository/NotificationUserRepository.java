package com.example.notification.user.repository;

import com.example.notification.user.entity.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationUserRepository
        extends JpaRepository<NotificationUser, UUID> {

    Optional<NotificationUser>
    findByInstitutionCodeAndExternalUserId(
            String institutionCode,
            String externalUserId
    );
}