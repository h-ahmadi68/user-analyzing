package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
public class PaymentLink {

    private String id;
    private String userId;
    private String url;
    private BigDecimal amount;
    private Bank bank;
    private PaymentLinkStatus status;
    private Instant createdAt;
    private Instant expiresAt;
}
