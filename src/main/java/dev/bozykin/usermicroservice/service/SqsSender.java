package dev.bozykin.usermicroservice.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import dev.bozykin.usermicroservice.entity.GameEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqsSender {
    private final QueueMessagingTemplate queueMessagingTemplate;

    public SqsSender(final AmazonSQSAsync amazonSQSAsync) {
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void send(final GameEntity game) {
        queueMessagingTemplate.convertAndSend("elo-add-game", game);
        log.info("Published SQS: {}", game);
    }
}
