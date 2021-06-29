package com.jung.app.randomnumber.service;

import java.io.IOException;
import java.util.Map;

import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseTemplate> consume(Map<String,String> json) throws IOException {
//		Map<String,String> json = JsonUtil.stringToJson(message);
        LOGGER.info("Consumed message : "+json);
        responseRandomNumberProducer.produce(json);
        return ResponseTemplate.toResponseEntity(ResponseCode.SUCCESS);
    }
}
