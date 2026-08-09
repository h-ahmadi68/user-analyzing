package com.example.demo.service;

import org.example.event.PaymentEvent;

public interface EventHandler<E extends PaymentEvent> {

    Class<? extends PaymentEvent> getActionClass();

    void handle(E action);
}
