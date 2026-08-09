package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.event.*;

import java.time.Instant;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AskForLink.class, name = "ASK_FOR_LINK"),
        @JsonSubTypes.Type(value = SendLink.class, name = "SEND_LINK"),
        @JsonSubTypes.Type(value = OpenLink.class, name = "OPEN_LINK"),
        @JsonSubTypes.Type(value = SubmitLink.class, name = "SUBMIT_LINK"),
        @JsonSubTypes.Type(value = RejectLink.class, name = "REJECT_LINK"),
})
public sealed interface PaymentEventDto
        permits AskForLinkDto, SendLinkDto, OpenLinkDto, SubmitLinkDto, RejectLinkDto {

    Instant timestamp();

    PaymentEvent toModel();

}
