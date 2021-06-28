package com.jung.app.randomnumber.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerater {
    private static final int MAX_NUMBER = 1000000;
    private static final int MIN_NUMBER = 0;
    private static final int NUMBER_LENGTH = 6;

    public String generateRandomNumber() {
        return Integer.toString(new Random()
                .ints(NUMBER_LENGTH, MIN_NUMBER, MAX_NUMBER)
                .findFirst()
                .getAsInt());
    }
}
