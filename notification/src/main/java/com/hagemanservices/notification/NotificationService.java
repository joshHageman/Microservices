package com.hagemanservices.notification;

import com.hagemanservices.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void createNotification (NotificationRequest notificationRequest) {
        NotificationEntity notificationEntity = NotificationEntity.builder()
                        .customerId(notificationRequest.customerId())
                        .sentAt(notificationRequest.time())
                        .message(notificationRequest.message())
                        .customerEmail(notificationRequest.customerEmail())
                        .build();
        notificationRepository.save(notificationEntity);

    }
}
