package com.example.notification.template;

import com.example.notification.institution.Institution;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.enums.ChannelType;
import com.example.notification.template.enums.NotificationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @Date 12/05/2026
 */
public interface TemplateRepository
        extends JpaRepository<NotificationTemplate, UUID> {

    Optional<NotificationTemplate>
    findByInstitutionAndCategoryAndChannel(
            Institution institution,
            NotificationCategory category,
            ChannelType channel
    );

    Optional<NotificationTemplate> findByInstitution_CodeAndCategoryAndChannel(
            String institutionCode,
            NotificationCategory category,
            ChannelType channel
    );
}