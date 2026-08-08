package com.example.demo.model.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Instant;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AskForLink.class, name = "ASK_FOR_LINK"),
        @JsonSubTypes.Type(value = SendLink.class, name = "SEND_LINK"),
        @JsonSubTypes.Type(value = OpenLink.class, name = "OPEN_LINK"),
        @JsonSubTypes.Type(value = SubmitLink.class, name = "SUBMIT_LINK"),
        @JsonSubTypes.Type(value = RejectLink.class, name = "REJECT_LINK"),
})
public sealed interface PaymentEvent permits AskForLink, SendLink, OpenLink, SubmitLink, RejectLink {

    Instant timestamp();
}
