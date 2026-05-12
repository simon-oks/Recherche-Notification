package com.example.notification.user.dto;

public record CreateUserRequest(

        String institutionCode,

        String externalUserId,

        String fullName,

        String email,

        String phoneNumber

) {
}