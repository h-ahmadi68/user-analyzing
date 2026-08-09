package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class KafkaProperties {

    @Value("${app.kafka.topic.payment-events}")
    private String topic;

}
