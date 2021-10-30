package com.jung.domain.dto;

<<<<<<< HEAD
import com.jung.domain.entity.RandomNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ResponseRandomNumberDTO {
    @NotBlank(message = "부모 ID 값이 없습니다.")
    private String parentId;
    @NotBlank(message = "자식 ID 값이 없습니다.")
    private String childId;
    private String randomNumber;
=======
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
>>>>>>> dev
}
