package com.example.demo.model.dto;

import lombok.Builder;
import org.example.event.PaymentEvent;
import org.example.event.SendLink;

import java.time.Instant;

@Builder
public record SendLinkDto(Instant timestamp, String paymentLinkId, String userId,
                          String url) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return SendLink.builder()
                .timestamp(timestamp)
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .url(url)
                .build();
    }

}
