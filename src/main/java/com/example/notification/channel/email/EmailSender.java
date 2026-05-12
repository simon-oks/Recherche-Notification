package com.example.notification.channel.email;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender mailSender;

    public void sendHtml(
            String to,
            String subject,
            String body
    ) {

        try {

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(
                            message,
                            true
                    );

            helper.setTo(to);

            helper.setSubject(subject);

            helper.setText(body, true);

            mailSender.send(message);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Failed to send email",
                    ex
            );
        }
    }
}