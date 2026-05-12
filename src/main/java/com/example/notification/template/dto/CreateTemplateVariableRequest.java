package com.example.notification.template.dto;

import com.example.notification.template.enums.BusinessVariableType;

/**
 * @Date 12/05/2026
 */
public record CreateTemplateVariableRequest(

        String name,

        BusinessVariableType businessType,

        boolean required

) {
}