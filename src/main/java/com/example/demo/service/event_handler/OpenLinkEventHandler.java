package com.example.demo.service.event_handler;

import com.example.demo.service.event_publisher.KafkaEventPublisher;
import lombok.RequiredArgsConstructor;
import org.example.event.OpenLink;
import org.example.event.PaymentEvent;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenLinkEventHandler implements EventHandler<OpenLink> {

    private final KafkaEventPublisher kafkaEventPublisher;

    @Override
    public Class<? extends PaymentEvent> getActionClass() {
        return OpenLink.class;
    }

    @Override
    public void handle(OpenLink event) {
        kafkaEventPublisher.publish(event.userId(), event);
    }

}
