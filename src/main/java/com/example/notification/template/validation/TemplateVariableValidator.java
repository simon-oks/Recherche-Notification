package com.example.notification.template.validation;

import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.entity.TemplateVariable;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Date 12/05/2026
 */
@Component
public class TemplateVariableValidator {

    public void validate(
            NotificationTemplate template,
            Map<String, Object> variables
    ) {

        for (TemplateVariable variable
                : template.getVariables()) {

            if (variable.isRequired()
                    && !variables.containsKey(
                    variable.getName()
            )) {

                throw new RuntimeException(
                        "Missing variable: "
                                + variable.getName()
                );
            }
        }
    }
}