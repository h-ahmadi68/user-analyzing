package com.example.demo.service;

import org.example.event.PaymentEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final Map<Class<? extends PaymentEvent>, EventHandler<PaymentEvent>> eventHandlerMap;


    @SuppressWarnings("unchecked")
    public EventService(List<EventHandler<? extends PaymentEvent>> eventHandlers) {
        eventHandlerMap = new HashMap<>();
        for (EventHandler<? extends PaymentEvent> eventHandler : eventHandlers) {
            eventHandlerMap.put(eventHandler.getActionClass(), (EventHandler<PaymentEvent>) eventHandler);
        }
    }

    public <E extends PaymentEvent> void eventProcess(E paymentEvent) {
        eventHandlerMap.get(paymentEvent.getClass()).handle(paymentEvent);
    }

}
