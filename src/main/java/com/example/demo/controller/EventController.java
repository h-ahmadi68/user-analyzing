package com.example.demo.controller;

import com.example.demo.model.dto.PaymentEventDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/events")
class EventController {

    @PostMapping("add-event")
    PaymentEventDto addEvent(@RequestBody PaymentEventDto event) {
        return event;
    }
}
