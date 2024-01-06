package com.github.regyl.unfriendlyjarvis.config;

import com.github.regyl.unfriendlyjarvis.exceptiion.UserAlreadyExistsException;
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

/**
 * Rest controllers exception handler.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * When connection wasn't established, feign causes error with status below.
     */
    private static final int NO_CONNECTION_FEIGN_EXCEPTION_STATUS = -1;
    
    /**
     * Handle the rest exceptions.
     *
     * @param e unhandled runtime exception
     * @return  exception information
     */
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

    /**
     * Handle the user already exists exception.
     *
     * @param e user already exists exception
     * @return  exception information
     */
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public Map<String, Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        log.warn("UserAlreadyExistsException", e);
        return buildResponseFromException(e);
    }

    /**
     * Handle the user not found exception.
     *
     * @param e username not found exception
     * @return  exception information
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, Object> handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.warn("UsernameNotFoundException", e);
        return buildResponseFromException(e);
    }

    /**
     * Handle the feign exceptions.
     *
     * <p>
     * Response status is transferred from feign exception
     *
     * @param e                 feign exception
     * @param servletResponse   servlet response
     * @return                  exception information
     */
    @ExceptionHandler(FeignException.class)
    public Map<String, Object> handleFeignException(FeignException e, HttpServletResponse servletResponse) {
        log.warn("FeignException: {}", e.getMessage());
        
        if (NO_CONNECTION_FEIGN_EXCEPTION_STATUS != e.status()) { //little crunch to translate exception status code
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
