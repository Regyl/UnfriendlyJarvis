package com.github.regyl.config.async;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * {@link RejectedExecutionHandler} that discards and cancel the oldest task in given {@link ThreadPoolExecutor}.
 */
@Slf4j
@NoArgsConstructor
public class DiscardOldestRejectedExecutionHandler implements RejectedExecutionHandler {

    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        Runnable dropped = e.getQueue().poll();
        if (dropped instanceof Future<?>) {
            ((Future<?>) dropped).cancel(Boolean.TRUE);
        }

        e.execute(r);  // retry
    }
}