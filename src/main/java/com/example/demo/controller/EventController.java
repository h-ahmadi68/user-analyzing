package com.example.demo.controller;

import com.example.demo.model.dto.PaymentEventDto;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/events")
class EventController {

    private final EventService eventService;

    @PostMapping("add-event")
    PaymentEventDto addEvent(@RequestBody PaymentEventDto event) {
        eventService.eventProcess(event.toModel());
        return event;
    }
}
