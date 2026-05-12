package com.example.notification.template.renderer;

import com.example.notification.template.enums.TemplateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RendererResolver {

    private final List<TemplateRenderer> renderers;

    public TemplateRenderer resolve(
            TemplateFormat format
    ) {

        return renderers.stream()
                .filter(renderer ->
                        renderer.getFormat() == format
                )
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(
                                "Renderer not found"
                        ));
    }
}