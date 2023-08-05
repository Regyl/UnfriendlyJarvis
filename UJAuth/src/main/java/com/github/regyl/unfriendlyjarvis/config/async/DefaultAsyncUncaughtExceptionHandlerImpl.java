package com.github.regyl.unfriendlyjarvis.config.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Default implementation of {@link AsyncUncaughtExceptionHandler} with logging.
 */
@Slf4j(topic = "DefaultAsyncUncaughtExceptionHandlerImpl")
public class DefaultAsyncUncaughtExceptionHandlerImpl implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        String exceptionMessage = String.format("In method %s#%s called exception of type %s: %s with calling arguments %s",
                method.getDeclaringClass(), method.getName(), ex.getClass(), ex.getMessage(), Arrays.toString(params));
        log.warn(exceptionMessage);
    }
}
