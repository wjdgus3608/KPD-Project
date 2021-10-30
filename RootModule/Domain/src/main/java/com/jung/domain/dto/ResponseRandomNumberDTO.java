package com.jung.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jung.domain.entity.RandomNumber;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class ResponseRandomNumberDTO {
    private Long id;
    private String parentId;
    private String childId;
    private String randomNumber;

    public static RandomNumber jsonToEntity(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, RandomNumber.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
