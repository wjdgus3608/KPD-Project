package com.jung.app.randomnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jung.app.*")
@ComponentScan("com.jung.client.*")
@ComponentScan("com.jung.domain.*")
public class RandomNumberApplication {
    public static void main(String[] args) {
        SpringApplication.run(RandomNumberApplication.class, args);
    }
}
