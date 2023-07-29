package com.github.regyl.config.async;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AsyncConfig {

    private final AsyncConfigProperties asyncConfigProperties;

    @Bean("defaultAsyncExecutor")
    public Executor backgroundExecutor() {
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
}
