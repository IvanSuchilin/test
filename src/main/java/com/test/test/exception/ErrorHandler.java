package com.test.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({RequestValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleRequestValidationException(
            final RequestValidationException e
    ) {
        log.debug("Возникла ошибка {},", e.getMessage());
        return Map.of(
                "message", e.getMessage(),
                "reason", e.getReason(),
                "status", "BAD_REQUEST",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}
