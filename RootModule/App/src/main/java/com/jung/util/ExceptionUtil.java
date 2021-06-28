package com.jung.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jung.domain.response.ResponseCode;
import com.jung.domain.response.ResponseVO;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@RestControllerAdvice
@Slf4j
public class ExceptionUtil {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ResponseVO> ExceptionAdvice(IOException e) {
//        log.error("IOException",e);
        ResponseVO responseVO = new ResponseVO(ResponseCode.REQUEST_INFO_NOT_SATISFIED);
        log.info("mylog",responseVO.getMessage());
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }

}
