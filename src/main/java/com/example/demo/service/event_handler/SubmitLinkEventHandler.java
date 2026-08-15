package com.example.demo.service.event_handler;


import com.example.demo.service.event_publisher.KafkaEventPublisher;
import lombok.RequiredArgsConstructor;
import org.example.event.PaymentEvent;
import org.example.event.SendLink;
import org.example.event.SubmitLink;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubmitLinkEventHandler implements EventHandler<SubmitLink> {

    private final KafkaEventPublisher kafkaEventPublisher;

    @Override
    public Class<? extends PaymentEvent> getActionClass() {
        return SendLink.class;
    }

    @Override
    public void handle(SubmitLink event) {
        kafkaEventPublisher.publish(event.userId(), event);
    }
}
