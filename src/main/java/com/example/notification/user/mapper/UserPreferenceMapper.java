package com.example.notification.user.mapper;

import com.example.notification.user.dto.PreferenceResponse;
import com.example.notification.user.entity.UserPreference;

public class UserPreferenceMapper {

    private UserPreferenceMapper() {
    }

    public static PreferenceResponse toResponse(
            UserPreference preference
    ) {

        return new PreferenceResponse(
                preference.getChannel(),
                preference.isEnabled()
        );
    }
}
