package com.jung.client.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConnector {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaConnector(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public String send(String topic, String message) {
        kafkaTemplate.send(topic, message);
        return "sent to kafka";
    }
}
