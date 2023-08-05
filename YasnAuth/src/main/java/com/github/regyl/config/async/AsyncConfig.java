package com.github.regyl.config.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Initialization of default async task executor and async exception handler.
 */
@EnableAsync
@Configuration
public class AsyncConfig {
    
    /**
     * Initialize default async task executor of type {@link ThreadPoolTaskExecutor}.
     *
     * @param asyncConfigProperties async config properties.
     * @return                      default async task executor.
     */
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
    
    /**
     * Initialize default async uncaught exception handler of type {@link AsyncUncaughtExceptionHandler}.
     *
     * @return default async uncaught exception handler.
     */
    @Bean("defaultAsyncUncaughtExceptionHandler")
    public AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler() {
        return new DefaultAsyncUncaughtExceptionHandlerImpl();
    }

}
