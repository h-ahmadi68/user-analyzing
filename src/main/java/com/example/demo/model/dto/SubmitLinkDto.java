package com.example.demo.model.dto;

import lombok.Builder;
import org.example.event.PaymentEvent;
import org.example.event.SubmitLink;

import java.time.Instant;

@Builder
public record SubmitLinkDto(Instant timestamp, String paymentLinkId,
                            String userId) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return SubmitLink.builder()
                .timestamp(timestamp)
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .build();
    }

}
