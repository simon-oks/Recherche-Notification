package com.example.notification.institution.mapper;

import com.example.notification.institution.Institution;
import com.example.notification.institution.dto.InstitutionResponse;

public class InstitutionMapper {

    private InstitutionMapper() {
    }

    public static InstitutionResponse toResponse(Institution institution) {

        return new InstitutionResponse(
                institution.getId(),
                institution.getCode(),
                institution.getName(),
                institution.isActive()
        );
    }
}