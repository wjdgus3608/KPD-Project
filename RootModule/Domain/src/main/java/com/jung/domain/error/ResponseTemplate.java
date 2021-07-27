package com.jung.domain.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ResponseTemplate {
    private final String code;
    private final String message;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public static ResponseEntity<ResponseTemplate> toResponseEntity(ResponseCode responseCode) {
        return ResponseEntity
                .status(responseCode.getHttpStatus())
                .body(ResponseTemplate.builder()
                        .code(responseCode.getHttpStatus().name())
                        .message(responseCode.getMessage())
                        .build()
                );
    }
}
