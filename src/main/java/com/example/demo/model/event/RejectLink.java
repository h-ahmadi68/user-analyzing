package com.example.demo.model.event;

import java.time.Instant;

public record RejectLink(Instant timestamp, String paymentLinkId,
                         String userId) implements PaymentEvent, PaymentEventDto {
}
