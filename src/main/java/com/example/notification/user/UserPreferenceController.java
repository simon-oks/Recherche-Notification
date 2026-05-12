package com.example.notification.user;

import com.example.notification.user.dto.CreatePreferenceRequest;
import com.example.notification.user.dto.PreferenceResponse;
import com.example.notification.user.entity.UserPreference;
import com.example.notification.user.mapper.UserPreferenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preferences")
@RequiredArgsConstructor
public class UserPreferenceController {

    private final UserPreferenceService service;

    @PostMapping
    public PreferenceResponse create(
            @RequestBody CreatePreferenceRequest request
    ) {

        UserPreference preference =
                service.create(request);

        return UserPreferenceMapper
                .toResponse(preference);
    }
}
