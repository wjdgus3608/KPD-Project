package com.jung.domain.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;


@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(OK,"요청성공"),
    REQUEST_INFO_INVALIDED(BAD_REQUEST,"부모ID, 자녀ID가 올바르지 않습니다."),
    ERROR(NOT_FOUND,"에러");

    private final HttpStatus httpStatus;
    private final String message;
}
