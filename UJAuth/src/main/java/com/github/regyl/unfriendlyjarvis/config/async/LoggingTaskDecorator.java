package com.github.regyl.unfriendlyjarvis.config.async;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskDecorator;

import java.util.concurrent.TimeUnit;

/**
 * Default implementation of {@link TaskDecorator} with logging.
 *
 * <p>
 * Used in {@link AsyncConfig}
 */
@Slf4j(topic = "LoggingTaskDecorator")
@NoArgsConstructor
public class LoggingTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(@NotNull Runnable runnable) {
        return () -> {
            long startTime = System.nanoTime();

            runnable.run();

            long endTime = System.nanoTime();
            log.debug("Task executed in {} ms", TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
        };
    }
}
