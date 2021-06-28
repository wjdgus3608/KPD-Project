package com.jung.app.randomnumber.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jung.app.randomnumber.util.RandomNumberGenerater;

@Service
public class GenerateRandomNumberConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateRandomNumberConsumer.class);

    @Autowired
    private RandomNumberGenerater randomNumberGenerater;
    @Autowired
    private ResponseRandomNumberProducer responseRandomNumberProducer;

    @KafkaListener(topics = "generateRandomNumber", groupId = "generateRandomNumberGroup", concurrency = "4")
    public String consume(Map<String,String> json) throws IOException {
//		Map<String,String> json = JsonUtil.stringToJson(message);
        LOGGER.info("Consumed message : "+json);
        responseRandomNumberProducer.produce(json);
        return "200";
    }
}
