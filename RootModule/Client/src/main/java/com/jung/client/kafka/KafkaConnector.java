package com.jung.client.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConnector {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(String topic, String message) {
        kafkaTemplate.send(topic, message);
        return "sent to kafka";
    }
}
