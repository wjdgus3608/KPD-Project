package com.jung.domain.response;

import lombok.Getter;

@Getter
public enum ResponseCode {

    ERROR("404","에러");

    private final String code;
    private final String message;

    ResponseCode(final String code, final String message) {
        this.message = message;
        this.code = code;
    }
}
