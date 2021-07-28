package com.jung.app.randomnumberdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jung.app.*")
@ComponentScan("com.jung.client.*")
@ComponentScan("com.jung.domain.*")
@ServletComponentScan
public class RandomNumberDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.jung.app.randomnumberdb.RandomNumberDBApplication.class, args);
    }
}
