package com.example.demo.model.payment_link;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record PaymentLink(String id, String userId, String url,
                          BigDecimal amount, Bank bank, PaymentLinkStatus status,
                          Instant CreatedAt) {

}
