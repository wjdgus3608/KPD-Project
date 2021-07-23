package com.jung.app.randomnumber.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GenerateRandomNumberDTO {
    @NotBlank(message = "부모 ID 값이 없습니다.")
    private String parentId;
    @NotBlank(message = "자식 ID 값이 없습니다.")
    private String childId;
    private String randomNumber;
}
