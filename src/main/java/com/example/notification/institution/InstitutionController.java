package com.example.notification.institution;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService service;

    @PostMapping
    public InstitutionResponse create(
            @RequestBody CreateInstitutionRequest request
    ) {

        Institution institution = service.create(request);

        return InstitutionMapper.toResponse(institution);
    }

    @GetMapping("/{code}")
    public InstitutionResponse findByCode(
            @PathVariable String code
    ) {

        Institution institution = service.findByCode(code);

        return InstitutionMapper.toResponse(institution);
    }
}