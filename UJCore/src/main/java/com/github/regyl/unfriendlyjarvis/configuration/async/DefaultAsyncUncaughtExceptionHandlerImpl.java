package com.github.regyl.unfriendlyjarvis.configuration.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class DefaultAsyncUncaughtExceptionHandlerImpl implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {

    }
}
