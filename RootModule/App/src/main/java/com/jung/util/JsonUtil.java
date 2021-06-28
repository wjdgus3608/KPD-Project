package com.jung.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String jsonToString(Map<String,String> map) {
        String result = null;
        try {
            result = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String,String> stringToJson(String message){
        Map<String,String> result = null;
        try {
            result = mapper.readValue(message, Map.class);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
