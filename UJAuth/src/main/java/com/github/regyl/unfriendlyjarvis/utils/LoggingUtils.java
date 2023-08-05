package com.github.regyl.unfriendlyjarvis.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Utility class for logging.
 */
@Slf4j(topic = "Default")
public final class LoggingUtils {
    
    /**
     * Log method execution time.
     *
     * @param startTime start time
     * @param message   message to log
     */
    public static void log(long startTime, String message) {
        long endTime = System.nanoTime();
        log.debug("{} ms: {}", message, TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
    }
}
