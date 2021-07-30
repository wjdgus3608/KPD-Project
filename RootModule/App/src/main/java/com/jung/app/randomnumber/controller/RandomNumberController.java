package com.jung.app.randomnumber.controller;

import java.io.IOException;
import java.util.Map;

import com.jung.domain.dto.GenerateRandomNumberDTO;
import com.jung.domain.error.ApiException;
import com.jung.domain.error.ResponseCode;
import com.jung.domain.error.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jung.app.randomnumber.service.GenerateRandomNumberConsumer;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/req-randomnumber")
@RestController
public class RandomNumberController {

    @Autowired
    private GenerateRandomNumberConsumer generateRandomNumberConsumer;

    @PostMapping
    public ResponseEntity<ResponseTemplate> generateRandomNumber(@RequestBody @Valid GenerateRandomNumberDTO json, Errors errors) {
        if(errors.hasErrors()){
            return ResponseTemplate.toResponseEntity(ResponseCode.REQUEST_INFO_INVALIDED);
        }

        ResponseEntity<ResponseTemplate> response = generateRandomNumberConsumer.consume(json);
        log.info("요청결과 : {}",response.getStatusCode());
        return ResponseTemplate.toResponseEntity(ResponseCode.SUCCESS);
    }

}
