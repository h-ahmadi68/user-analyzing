package com.example.demo.service.event_handler;

import com.example.demo.service.event_publisher.KafkaEventPublisher;
import lombok.RequiredArgsConstructor;
import org.example.event.PaymentEvent;
import org.example.event.SendLink;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendLinkEventHandler implements EventHandler<SendLink> {

    private final KafkaEventPublisher kafkaEventPublisher;

    @Override
    public Class<? extends PaymentEvent> getActionClass() {
        return SendLink.class;
    }

    @Override
    public void handle(SendLink event) {
        kafkaEventPublisher.publish(event.userId(), event);
    }

}
