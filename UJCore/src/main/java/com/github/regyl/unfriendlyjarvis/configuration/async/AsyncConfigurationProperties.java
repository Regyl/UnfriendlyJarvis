package com.github.regyl.unfriendlyjarvis.configuration.async;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.application.async")
public class AsyncConfigurationProperties {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private boolean allowCoreThreadTimeOut;

    private int awaitTerminationSeconds;
}
