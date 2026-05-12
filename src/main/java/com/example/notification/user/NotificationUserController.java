package com.example.notification.user;

import com.example.notification.user.dto.CreateUserRequest;
import com.example.notification.user.dto.UserResponse;
import com.example.notification.user.entity.NotificationUser;
import com.example.notification.user.mapper.NotificationUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class NotificationUserController {

    private final NotificationUserService service;

    @PostMapping
    public UserResponse create(
            @RequestBody CreateUserRequest request
    ) {

        NotificationUser user =
                service.create(request);

        return NotificationUserMapper
                .toResponse(user);
    }
}