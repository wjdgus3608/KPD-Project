package com.jung.app.randomnumber.service;

import java.io.IOException;
import java.util.Map;

import com.jung.app.randomnumber.dto.GenerateRandomNumberDTO;
import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GenerateRandomNumberConsumer {

    @Autowired
    private ResponseRandomNumberProducer responseRandomNumberProducer;

    @KafkaListener(topics = "generateRandomNumber", groupId = "generateRandomNumberGroup", concurrency = "4")
    public ResponseEntity<ResponseTemplate> consume(GenerateRandomNumberDTO json) {
        log.info("Consumed message : "+json);
        responseRandomNumberProducer.produce(json);
        return ResponseTemplate.toResponseEntity(ResponseCode.SUCCESS);
    }
}
