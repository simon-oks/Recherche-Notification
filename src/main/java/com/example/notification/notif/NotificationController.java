package com.example.notification.notif;

import com.example.notification.notif.dto.NotificationResponse;
import com.example.notification.notif.dto.SendNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 12/05/2026
 */
@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public NotificationResponse send(
            @RequestBody SendNotificationRequest request
    ) {
        return service.send(request);
    }
}