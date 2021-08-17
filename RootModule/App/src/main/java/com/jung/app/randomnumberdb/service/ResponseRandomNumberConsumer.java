package com.jung.app.randomnumberdb.service;

import com.jung.app.randomnumber.util.RandomNumberGenerator;
import com.jung.client.kafka.KafkaConnector;
import com.jung.domain.dto.ResponseRandomNumberDTO;
import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import com.jung.repository.RandomNumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResponseRandomNumberConsumer {
    private static final String TOPIC = "responseRandomNumber";

    @Autowired
    KafkaConnector kafkaConnector;
    @Autowired
    RandomNumberRepository randomNumberRepository;

    @KafkaListener(topics = TOPIC, groupId = "responseRandomNumberGroup", concurrency = "4")
    public ResponseEntity<ResponseTemplate> consume(String json) {
        log.info("Produce message : "+json);
        randomNumberRepository.save(ResponseRandomNumberDTO.jsonToEntity(json));
        return ResponseTemplate.toResponseEntity(ResponseCode.SUCCESS);
    }
}
