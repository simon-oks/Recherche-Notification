package com.example.notification.institution.dto;

import java.util.UUID;

public record InstitutionResponse(

        UUID id,

        String code,

        String name,

        boolean active

) {
}