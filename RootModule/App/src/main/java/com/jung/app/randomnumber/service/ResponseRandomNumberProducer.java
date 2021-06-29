package com.jung.app.randomnumber.service;

import java.util.Map;

import com.jung.client.kafka.KafkaConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.app.randomnumber.util.RandomNumberGenerater;

import com.jung.globalutil.JsonUtil;

@Service
public class ResponseRandomNumberProducer {
    private static final String TOPIC = "responseRandomNumber";
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseRandomNumberProducer.class);

    @Autowired
    KafkaConnector kafkaConnector;

    @Autowired
    private RandomNumberGenerater randomNumberGenerater;

    public void produce(Map<String,String> json) {
        String randomNumber = randomNumberGenerater.generateRandomNumber();
        json.put("randomNumber",randomNumber);

        String message = JsonUtil.jsonToString(json);
        LOGGER.info("Produce message : "+message);

        kafkaConnector.send(TOPIC, message);
    }
}
