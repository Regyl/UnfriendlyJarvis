package com.github.regyl.config;

import com.github.regyl.exceptiion.UserAlreadyExistsException;
import feign.FeignException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * When connection wasn't established, feign causes error with status below.
     */
    private static final int NO_CONNECTION_FEIGN_EXCEPTION_STATUS = -1;

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Map<String, Object> handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException", e);
        e.printStackTrace();

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

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public Map<String, Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        log.warn("UserAlreadyExistsException", e);
        return buildResponseFromException(e);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, Object> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.warn("UsernameNotFoundException", e);
        return buildResponseFromException(e);
    }

    @ExceptionHandler(FeignException.class)
    public Map<String, Object> handleFeignException(FeignException e, HttpServletResponse servletResponse) {
        if (NO_CONNECTION_FEIGN_EXCEPTION_STATUS != e.status()) {
            servletResponse.setStatus(e.status());
        } else {
            servletResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        }

        return buildResponseFromException(e);
    }

    private Map<String, Object> buildResponseFromException(Throwable e) {
        Map<String, Object> body = new HashMap<>(4, 1);

        body.put("message", e.getMessage());
        body.put("timestamp", OffsetDateTime.now(Clock.systemUTC()));
        body.put("type", e.getClass());

        return body;
    }
}
