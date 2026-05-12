package com.example.notification.user;

import com.example.notification.user.dto.CreatePreferenceRequest;
import com.example.notification.user.entity.NotificationUser;
import com.example.notification.user.entity.UserPreference;
import com.example.notification.user.repository.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPreferenceService {

    private final UserPreferenceRepository repository;

    private final NotificationUserService userService;

    public UserPreference create(
            CreatePreferenceRequest request
    ) {

        NotificationUser user =
                userService.find(
                        request.institutionCode(),
                        request.externalUserId()
                );

        UserPreference preference =
                new UserPreference();

        preference.setUser(user);

        preference.setChannel(
                request.channel()
        );

        preference.setEnabled(
                request.enabled()
        );

        return repository.save(preference);
    }
}