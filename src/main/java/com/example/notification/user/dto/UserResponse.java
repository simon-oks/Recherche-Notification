package com.example.notification.user.dto;

import java.util.UUID;

public record UserResponse(

        UUID id,

        String externalUserId,

        String fullName,

        String email,

        String phoneNumber

) {
}