package com.example.demo.model.dto;

import lombok.Builder;
import org.example.event.OpenLink;
import org.example.event.PaymentEvent;

import java.time.Instant;

@Builder
public record OpenLinkDto(Instant timestamp, String paymentLinkId,
                          String userId) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return OpenLink.builder()
                .timestamp(timestamp)
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .build();
    }

}