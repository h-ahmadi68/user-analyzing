package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.event.AskForLink;
import org.example.event.PaymentEvent;
import org.example.payment_link.Bank;

import java.math.BigDecimal;
import java.time.Instant;

@Schema(example = """
        {
          "type": "ASK_FOR_LINK",
          "timestamp": "2026-08-09T11:30:00Z",
          "userId": "user-123",
          "amount": 1500000.50,
          "bank": "MELLAT"
        }
        """)
@Builder
public record AskForLinkDto(Instant timestamp, String userId, BigDecimal amount,
                            Bank bank) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return AskForLink.builder()
                .timestamp(Instant.now())
                .userId(userId)
                .amount(amount)
                .bank(bank)
                .build();
    }

}
