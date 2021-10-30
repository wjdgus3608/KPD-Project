package com.jung.app.randomnumberdb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.client.kafka.KafkaConnector;
<<<<<<< HEAD
import com.jung.domain.entity.RandomNumber;
import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import com.jung.app.randomnumberdb.repository.RandomNumberRepository;
=======
import com.jung.domain.dto.ResponseRandomNumberDTO;
import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import com.jung.repository.RandomNumberRepository;
>>>>>>> dev
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
<<<<<<< HEAD
    private KafkaConnector kafkaConnector;

    @Autowired
    private RandomNumberRepository randomNumberRepository;
=======
    KafkaConnector kafkaConnector;
//    @Autowired
//    RandomNumberRepository randomNumberRepository;
>>>>>>> dev

    @KafkaListener(topics = TOPIC, groupId = "responseRandomNumberGroup", concurrency = "4")
    public ResponseEntity<ResponseTemplate> consume(String json) throws JsonProcessingException {
        log.info("Produce message : "+json);
<<<<<<< HEAD

        ObjectMapper mapper = new ObjectMapper();
        RandomNumber randomNumber = mapper.readValue(json, RandomNumber.class);
        randomNumberRepository.save(randomNumber);

=======
        //randomNumberRepository.save(ResponseRandomNumberDTO.jsonToEntity(json));
>>>>>>> dev
        return ResponseTemplate.toResponseEntity(ResponseCode.SUCCESS);
    }
}
