package com.example.demo.model.dto;

import lombok.Builder;
import org.example.event.PaymentEvent;
import org.example.event.RejectLink;

import java.time.Instant;

@Builder
public record RejectLinkDto(Instant timestamp, String paymentLinkId,
                            String userId) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return RejectLink.builder()
                .timestamp(timestamp)
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .build();
    }

}
