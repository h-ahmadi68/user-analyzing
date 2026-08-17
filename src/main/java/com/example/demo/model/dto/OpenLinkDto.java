package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.event.OpenLink;
import org.example.event.PaymentEvent;

import java.time.Instant;

@Schema(example = """
        {
          "type": "OPEN_LINK",
          "timestamp": "2026-08-09T11:32:00Z",
          "paymentLinkId": "link-123456",
          "userId": "user-123"
        }
        """)
@Builder
public record OpenLinkDto(Instant timestamp, String paymentLinkId,
                          String userId) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return OpenLink.builder()
                .timestamp(Instant.now())
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .build();
    }

}