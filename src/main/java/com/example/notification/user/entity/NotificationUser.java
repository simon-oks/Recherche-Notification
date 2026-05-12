package com.example.notification.user.entity;

import com.example.notification.common.BaseEntity;
import com.example.notification.institution.Institution;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notification_users")
@Getter
@Setter
public class NotificationUser extends BaseEntity {

    @Column(nullable = false)
    private String externalUserId;

    private String email;

    private String phoneNumber;

    private String fullName;

    @ManyToOne(optional = false)
    private Institution institution;
}