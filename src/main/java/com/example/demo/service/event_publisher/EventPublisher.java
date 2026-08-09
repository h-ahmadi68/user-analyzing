package com.example.demo.service.event_publisher;

import org.example.event.PaymentEvent;

public interface EventPublisher {

    void publish(String key, PaymentEvent event);

}
