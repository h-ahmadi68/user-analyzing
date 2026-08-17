package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.event.PaymentEvent;
import org.example.event.RejectLink;

import java.time.Instant;

@Schema(example = """
        {
          "type": "REJECT_LINK",
          "timestamp": "2026-08-09T11:34:00Z",
          "paymentLinkId": "link-123456",
          "userId": "user-123"
        }
        """)
@Builder
public record RejectLinkDto(Instant timestamp, String paymentLinkId,
                            String userId) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return RejectLink.builder()
                .timestamp(Instant.now())
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .build();
    }

}
