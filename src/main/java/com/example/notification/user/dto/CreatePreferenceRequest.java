package com.example.notification.user.dto;

import com.example.notification.template.enums.ChannelType;

public record CreatePreferenceRequest(

        String institutionCode,

        String externalUserId,

        ChannelType channel,

        boolean enabled

) {
}