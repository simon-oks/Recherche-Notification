package com.example.notification.institution;

import java.util.UUID;

public record InstitutionResponse(

        UUID id,

        String code,

        String name,

        boolean active

) {
}