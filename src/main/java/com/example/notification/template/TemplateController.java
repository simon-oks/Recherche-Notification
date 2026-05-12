package com.example.notification.template;

import com.example.notification.template.dto.CreateTemplateRequest;
import com.example.notification.template.dto.TemplateResponse;
import com.example.notification.template.entity.NotificationTemplate;
import com.example.notification.template.mapper.TemplateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

/**
 * @Date 12/05/2026
 */
@RestController
@RequestMapping("/templates")
@RequiredArgsConstructor
public class TemplateController {

    private final TemplateService service;

    @PostMapping
    public TemplateResponse create(
            @RequestBody CreateTemplateRequest request
    ) {

        NotificationTemplate template =
                service.create(request);

        return TemplateMapper.toResponse(template);
    }
}