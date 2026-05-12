package com.example.notification.user.entity;

import com.example.notification.common.BaseEntity;
import com.example.notification.template.enums.ChannelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_preferences")
@Getter
@Setter
public class UserPreference extends BaseEntity {

    @ManyToOne(optional = false)
    private NotificationUser user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChannelType channel;

    private boolean enabled = true;
}