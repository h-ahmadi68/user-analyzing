package com.example.demo.controller;

import com.example.demo.model.event.PaymentEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
class EventController {

    @PostMapping("add-event")
    PaymentEvent addEvent(@RequestBody PaymentEvent event) {
        return event;
    }
}
