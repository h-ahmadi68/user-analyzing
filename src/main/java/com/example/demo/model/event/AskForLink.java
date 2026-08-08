package com.example.demo.model.event;

import com.example.demo.model.payment_link.Bank;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record AskForLink(Instant timestamp, String userId, BigDecimal amount,
                         Bank bank) implements PaymentEvent, PaymentEventDto {
}
