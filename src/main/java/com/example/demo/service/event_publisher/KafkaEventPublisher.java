package com.example.demo.service.event_publisher;

import com.example.demo.config.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.event.PaymentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaProperties kafkaProperties;
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    @Override
    public void publish(String key, PaymentEvent event) {
        kafkaTemplate.send(kafkaProperties.getTopic(), key, event)
                .whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Failed to publish event {} with key={}", event.getClass().getSimpleName(), key, ex);
            } else {
                log.debug("Event {} with key={} was published to partition {}", event.getClass().getSimpleName(), key, result.getRecordMetadata().partition());
            }
        });
    }

}

