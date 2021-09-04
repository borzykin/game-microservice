package dev.bozykin.usermicroservice.service;

import dev.bozykin.usermicroservice.entity.GameEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SnsSender {
    private final NotificationMessagingTemplate messagingTemplate;

    public SnsSender(final NotificationMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void send(final GameEntity message, final String subject) {
        log.info("Sending message {} to topic {}", message, subject);
        messagingTemplate.sendNotification("topic", message, subject);
    }
}
