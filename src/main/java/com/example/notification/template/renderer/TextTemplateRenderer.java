package com.example.notification.template.renderer;

import com.example.notification.template.enums.TemplateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TextTemplateRenderer
        implements TemplateRenderer {

    private final TemplateEngine textTemplateEngine;

    @Override
    public TemplateFormat getFormat() {

        return TemplateFormat.TEXT;
    }

    @Override
    public String render(
            String template,
            Map<String, Object> variables
    ) {

        Context context = new Context();

        context.setVariables(variables);

        return textTemplateEngine.process(
                template,
                context
        );
    }
}