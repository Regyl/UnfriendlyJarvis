package com.github.regyl.config.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link org.springframework.scheduling.annotation.Async} beans initialization.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "application.async")
public class AsyncConfigProperties {

    private int corePoolSize = Runtime.getRuntime().availableProcessors() / 10 + 1;

    private int maxPoolSize = 5;

    private int queueCapacity = 500;
}
