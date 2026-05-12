package com.example.notification.user.dto;

import com.example.notification.template.enums.ChannelType;

public record PreferenceResponse(

        ChannelType channel,

        boolean enabled

) {
}