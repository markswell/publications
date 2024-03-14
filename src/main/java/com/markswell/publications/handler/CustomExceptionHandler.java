package com.markswell.publications.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import com.markswell.publications.domain.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(Exception exception, HttpServletRequest request) {
        var errorResponse = ErrorResponse.builder()
                .timestamp(System.currentTimeMillis())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();
        log.error("[ERROR] %s".formatted(exception.getMessage()), exception);
        return ResponseEntity.badRequest().body(errorResponse);

    }

}
