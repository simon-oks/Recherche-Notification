package com.example.notification.template.renderer;

import com.example.notification.template.enums.TemplateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class HtmlTemplateRenderer
        implements TemplateRenderer {

    private final TemplateEngine htmlTemplateEngine;

    @Override
    public TemplateFormat getFormat() {

        return TemplateFormat.HTML;
    }

    @Override
    public String render(
            String template,
            Map<String, Object> variables
    ) {

        Context context = new Context();

        context.setVariables(variables);

        return htmlTemplateEngine.process(
                template,
                context
        );
    }
}