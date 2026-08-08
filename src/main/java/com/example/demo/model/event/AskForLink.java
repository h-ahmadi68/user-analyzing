package com.example.demo.model.event;

import com.example.demo.model.Bank;

import java.math.BigDecimal;
import java.time.Instant;

public record AskForLink(Instant timestamp, String userId, BigDecimal amount, Bank bank) implements PaymentEvent {
}
