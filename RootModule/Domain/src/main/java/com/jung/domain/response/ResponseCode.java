package com.jung.domain.response;

import lombok.Getter;

@Getter
public enum ResponseCode {

    REQUEST_INFO_NOT_SATISFIED("400","요청 정보가 올바르지 않습니다."),
    ERROR("404","에러");

    private final String code;
    private final String message;

    ResponseCode(final String code, final String message) {
        this.message = message;
        this.code = code;
    }
}
