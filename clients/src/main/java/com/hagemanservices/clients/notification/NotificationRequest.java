package com.hagemanservices.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(Integer customerId, LocalDateTime time, String message, String customerEmail) {
}
