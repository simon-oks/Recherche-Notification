package com.example.notification.template.entity;

import com.example.notification.common.BaseEntity;
import com.example.notification.institution.Institution;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;
import com.example.notification.template.enums.TemplateFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notification_templates")
@Getter
@Setter
public class NotificationTemplate extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChannelType channel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TemplateFormat format;

    @Column(nullable = false)
    private String subject;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false)
    private Institution institution;

    @OneToMany(
            mappedBy = "template",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TemplateVariable> variables =
            new ArrayList<>();
}
