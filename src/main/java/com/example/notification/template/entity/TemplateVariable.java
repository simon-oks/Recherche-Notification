package com.example.notification.template.entity;

import com.example.notification.common.BaseEntity;
import com.example.notification.template.enums.BusinessVariableType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Date 12/05/2026
 */
@Entity
@Table(name = "template_variables")
@Getter
@Setter
public class TemplateVariable extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusinessVariableType businessType;

    private boolean required = true;

    @ManyToOne(optional = false)
    private NotificationTemplate template;
}