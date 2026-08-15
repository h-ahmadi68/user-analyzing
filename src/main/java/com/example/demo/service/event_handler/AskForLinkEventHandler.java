package com.example.demo.service.event_handler;

import com.example.demo.service.event_publisher.KafkaEventPublisher;
import lombok.RequiredArgsConstructor;
import org.example.event.AskForLink;
import org.example.event.PaymentEvent;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AskForLinkEventHandler implements EventHandler<AskForLink> {

    private final KafkaEventPublisher kafkaEventPublisher;

    @Override
    public Class<? extends PaymentEvent> getActionClass() {
        return AskForLink.class;
    }

    @Override
    public void handle(AskForLink event) {
        kafkaEventPublisher.publish(event.userId(), event);
    }

}
