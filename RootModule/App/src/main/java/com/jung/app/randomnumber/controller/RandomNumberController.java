package com.jung.app.randomnumber.controller;

import java.io.IOException;
import java.util.Map;

import com.jung.domain.error.CustomException;
import com.jung.domain.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jung.app.randomnumber.service.GenerateRandomNumberConsumer;

@RestController
@RequestMapping("/req-randomnumber")
@Slf4j
public class RandomNumberController {

    @Autowired
    private GenerateRandomNumberConsumer generateRandomNumberConsumer;

    @PostMapping
    public String generateRandomNumber(@RequestBody Map<String,String> json) throws IOException {
        checkRequestInfo(json);
        String result = generateRandomNumberConsumer.consume(json);
        log.info("result code : "+result);
        return result;
    }

    private void checkRequestInfo(Map<String,String> json) {
        if(json.containsKey("parent-id") && json.containsKey("child-id"))
            return;
        throw new CustomException(ErrorCode.REQUEST_INFO_INVALIDED);
    }
}
