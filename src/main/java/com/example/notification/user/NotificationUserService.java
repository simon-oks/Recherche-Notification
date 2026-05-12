package com.example.notification.user;

import com.example.notification.institution.Institution;
import com.example.notification.institution.InstitutionService;
import com.example.notification.user.dto.CreateUserRequest;
import com.example.notification.user.entity.NotificationUser;
import com.example.notification.user.repository.NotificationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationUserService {

    private final NotificationUserRepository repository;

    private final InstitutionService institutionService;

    public NotificationUser create(
            CreateUserRequest request
    ) {

        Institution institution =
                institutionService.findByCode(
                        request.institutionCode()
                );

        NotificationUser user =
                new NotificationUser();

        user.setInstitution(institution);

        user.setExternalUserId(
                request.externalUserId()
        );

        user.setFullName(
                request.fullName()
        );

        user.setEmail(
                request.email()
        );

        user.setPhoneNumber(
                request.phoneNumber()
        );

        return repository.save(user);
    }

    public NotificationUser find(
            String institutionCode,
            String externalUserId
    ) {

        return repository
                .findByInstitutionCodeAndExternalUserId(
                        institutionCode,
                        externalUserId
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        ));
    }
}