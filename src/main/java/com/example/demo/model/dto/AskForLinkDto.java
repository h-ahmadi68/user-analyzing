package com.example.demo.model.dto;

import lombok.Builder;
import org.example.event.AskForLink;
import org.example.event.PaymentEvent;
import org.example.payment_link.Bank;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record AskForLinkDto(Instant timestamp, String userId, BigDecimal amount,
                            Bank bank) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return AskForLink.builder()
                .timestamp(timestamp)
                .userId(userId)
                .amount(amount)
                .bank(bank)
                .build();
    }

}
