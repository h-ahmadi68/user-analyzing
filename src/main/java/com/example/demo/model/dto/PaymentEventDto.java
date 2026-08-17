package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.event.PaymentEvent;

import java.time.Instant;

@Schema(
        discriminatorProperty = "type",
        oneOf = {
                AskForLinkDto.class,
                SendLinkDto.class,
                OpenLinkDto.class,
                SubmitLinkDto.class,
                RejectLinkDto.class
        }
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AskForLinkDto.class, name = "ASK_FOR_LINK"),
        @JsonSubTypes.Type(value = SendLinkDto.class, name = "SEND_LINK"),
        @JsonSubTypes.Type(value = OpenLinkDto.class, name = "OPEN_LINK"),
        @JsonSubTypes.Type(value = SubmitLinkDto.class, name = "SUBMIT_LINK"),
        @JsonSubTypes.Type(value = RejectLinkDto.class, name = "REJECT_LINK"),
})
public sealed interface PaymentEventDto
        permits AskForLinkDto, SendLinkDto, OpenLinkDto,
        SubmitLinkDto, RejectLinkDto {

    Instant timestamp();

    PaymentEvent toModel();

}
