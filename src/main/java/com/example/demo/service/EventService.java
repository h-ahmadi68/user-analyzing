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
    public EventService(List<EventHandler<? extends PaymentEvent>> actionHandlers) {
        eventHandlerMap = new HashMap<>();
        for (EventHandler<? extends PaymentEvent> actionHandler : actionHandlers) {
            eventHandlerMap.put(actionHandler.getActionClass(), (EventHandler<PaymentEvent>) actionHandler);
        }
    }

    public <E extends PaymentEvent> void actionProcess(E paymentEvent) {
        eventHandlerMap.get(paymentEvent.getClass()).handle(paymentEvent);
    }

}
