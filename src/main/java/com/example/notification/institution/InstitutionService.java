package com.example.notification.institution;

import com.example.notification.institution.dto.CreateInstitutionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository repository;

    public Institution create(CreateInstitutionRequest request) {

        if (repository.existsByCode(request.code())) {
            throw new RuntimeException("Institution code already exists");
        }

        Institution institution = new Institution();

        institution.setCode(request.code());
        institution.setName(request.name());

        return repository.save(institution);
    }

    public Institution findByCode(String code) {

        return repository.findByCode(code)
                .orElseThrow(() ->
                        new RuntimeException("Institution not found"));
    }
}