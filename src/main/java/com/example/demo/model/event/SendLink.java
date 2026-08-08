package com.example.demo.model.event;

import java.time.Instant;

public record SendLink(Instant timestamp, String paymentLinkId, String userId,
                       String url) implements PaymentEvent, PaymentEventDto {
}
