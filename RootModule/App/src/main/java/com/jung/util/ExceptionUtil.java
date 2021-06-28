package com.jung.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jung.domain.response.ResponseCode;
import com.jung.domain.response.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionUtil {

    @ExceptionHandler(Exception.class)
    public ResponseVO ExceptionAdvice(Exception e) {
        log.error("Exception",e);
        return new ResponseVO(ResponseCode.ERROR);
    }

}
