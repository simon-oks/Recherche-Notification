package com.example.notification.template.renderer;

import com.example.notification.template.enums.TemplateFormat;

import java.util.Map;

public interface TemplateRenderer {

    TemplateFormat getFormat();

    String render(
            String template,
            Map<String, Object> variables
    );
}
