package com.jung.app.randomnumber.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jung.app.randomnumber.service.GenerateRandomNumberConsumer;

@RestController
@RequestMapping("/req-randomnumber")
public class RandomNumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomNumberController.class);

    @Autowired
    private GenerateRandomNumberConsumer generateRandomNumberConsumer;

    @PostMapping
    public String generateRandomNumber(@RequestBody Map<String,String> json) throws IOException {
        String result = generateRandomNumberConsumer.consume(json);
        LOGGER.info("result code : "+result);
        return result;
    }

    @PostMapping("/error")
    public void exceptionTest() throws Exception {
        throw new Exception("test error");
    }
}
