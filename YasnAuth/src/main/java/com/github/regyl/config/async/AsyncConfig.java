package com.github.regyl.config.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Initialization of default async task executor.
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean("defaultAsyncExecutor")
    public Executor backgroundExecutor(AsyncConfigProperties asyncConfigProperties) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncConfigProperties.getCorePoolSize());
        executor.setMaxPoolSize(asyncConfigProperties.getMaxPoolSize());
        executor.setQueueCapacity(asyncConfigProperties.getQueueCapacity());
        executor.setRejectedExecutionHandler(new DiscardOldestRejectedExecutionHandler());
        executor.setTaskDecorator(new LoggingTaskDecorator());
        executor.setThreadNamePrefix("Background-");
        executor.initialize();
        return executor;
    }

    @Bean("defaultAsyncUncaughtExceptionHandler")
    public AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler() {
        return new DefaultAsyncUncaughtExceptionHandlerImpl();
    }

}
