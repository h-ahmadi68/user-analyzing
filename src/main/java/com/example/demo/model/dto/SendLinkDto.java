package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.event.PaymentEvent;
import org.example.event.SendLink;

import java.time.Instant;

@Schema(example = """
        {
          "type": "SEND_LINK",
          "timestamp": "2026-08-09T11:31:00Z",
          "paymentLinkId": "link-123456",
          "userId": "user-123",
          "url": "https://payment.example.com/link-123456"
        }
        """
)
@Builder
public record SendLinkDto(Instant timestamp, String paymentLinkId, String userId,
                          String url) implements PaymentEventDto {

    @Override
    public PaymentEvent toModel() {
        return SendLink.builder()
                .timestamp(timestamp)
                .paymentLinkId(paymentLinkId)
                .userId(userId)
                .url(url)
                .build();
    }

}
