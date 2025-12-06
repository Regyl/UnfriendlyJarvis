package com.github.regyl.unfriendlyjarvis.configuration.async;

import lombok.RequiredArgsConstructor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class AsyncConfiguration implements AsyncConfigurer {

    private final AsyncConfigurationProperties configProps;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(configProps.getCorePoolSize());
        executor.setMaxPoolSize(configProps.getMaxPoolSize());
        executor.setKeepAliveSeconds(configProps.getKeepAliveSeconds());
        executor.setQueueCapacity(configProps.getQueueCapacity());
        executor.setAllowCoreThreadTimeOut(configProps.isAllowCoreThreadTimeOut());
        executor.setAwaitTerminationSeconds(configProps.getAwaitTerminationSeconds());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setPrestartAllCoreThreads(false);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("DefaultAsyncExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new DefaultAsyncUncaughtExceptionHandlerImpl();
    }
}
