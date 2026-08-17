package com.example.demo.service.event_handler;

import com.example.demo.service.event_publisher.KafkaEventPublisher;
import lombok.RequiredArgsConstructor;
import org.example.event.PaymentEvent;
import org.example.event.RejectLink;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RejectLinkEventHandler implements EventHandler<RejectLink> {

    private final KafkaEventPublisher kafkaEventPublisher;

    @Override
    public Class<? extends PaymentEvent> getActionClass() {
        return RejectLink.class;
    }

    @Override
    public void handle(RejectLink event) {
        kafkaEventPublisher.publish(event.userId(), event);
    }

}
