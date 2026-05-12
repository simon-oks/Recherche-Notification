package com.example.notification.user.mapper;

import com.example.notification.user.dto.UserResponse;
import com.example.notification.user.entity.NotificationUser;

public class NotificationUserMapper {

    private NotificationUserMapper() {
    }

    public static UserResponse toResponse(
            NotificationUser user
    ) {

        return new UserResponse(
                user.getId(),
                user.getExternalUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}