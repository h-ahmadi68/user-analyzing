package com.example.demo.model.event;

import java.time.Instant;

public record SubmitLink(Instant timestamp, String paymentLinkId, String userId) implements PaymentEvent {
}
