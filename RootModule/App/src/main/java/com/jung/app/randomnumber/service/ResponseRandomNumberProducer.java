package com.jung.app.randomnumber.service;

import java.util.Map;

import com.jung.client.kafka.KafkaConnector;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.app.randomnumber.util.RandomNumberGenerator;

import com.jung.globalutil.JsonUtil;

@Slf4j
@Service
public class ResponseRandomNumberProducer {
    private static final String TOPIC = "responseRandomNumber";

    @Autowired
    KafkaConnector kafkaConnector;

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    public void produce(Map<String,String> json) {
        String randomNumber = randomNumberGenerator.generateRandomNumber();
        json.put("randomNumber",randomNumber);

        String message = JsonUtil.jsonToString(json);
        log.info("Produce message : "+message);

        kafkaConnector.send(TOPIC, message);
    }
}
