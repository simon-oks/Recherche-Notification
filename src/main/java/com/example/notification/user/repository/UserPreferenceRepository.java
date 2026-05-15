package com.example.notification.user.repository;

import com.example.notification.template.enums.ChannelType;
import com.example.notification.user.entity.NotificationUser;
import com.example.notification.user.entity.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserPreferenceRepository
        extends JpaRepository<UserPreference, UUID> {

    Optional<UserPreference>
    findByUserAndChannel(
            NotificationUser user,
            ChannelType channel
    );
    List<UserPreference> findByUserAndEnabledTrue(
            NotificationUser user
    );
}