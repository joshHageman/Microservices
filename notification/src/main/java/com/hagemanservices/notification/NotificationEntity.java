package com.hagemanservices.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class NotificationEntity {
    @SequenceGenerator(
            name = "notification_id",
            sequenceName = "notification_id"
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id"
    )
    @Id
    private Integer id;
    private Integer customerId;
    private String message;
    private LocalDateTime sentAt;
    private String customerEmail;
}
