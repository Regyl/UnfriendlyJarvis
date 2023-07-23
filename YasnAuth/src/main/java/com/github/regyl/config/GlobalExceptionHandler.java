package com.github.regyl.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Map<String, Object> handleRuntimeException(RuntimeException e) {
        Map<String, Object> body = new HashMap<>(5, 1);
        body.put("message", e.getMessage());
        body.put("timestamp", OffsetDateTime.now(Clock.systemUTC()));
        body.put("type", e.getClass());

        Map<String, Object> currentBody = body;
        Throwable cause = e.getCause();
        while (cause != null) {
            Map<String, Object> newBody = new HashMap<>();
            currentBody.put("cause", newBody);
            newBody.put("message", cause.getMessage());
            newBody.put("type", cause.getClass());

            currentBody = newBody;
            cause = cause.getCause();
        }


        return body;
    }
}
