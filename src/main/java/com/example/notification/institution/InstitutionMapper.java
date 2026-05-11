package com.example.notification.institution;

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