package com.github.regyl.unfriendlyjarvis.config.async;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for {@link org.springframework.scheduling.annotation.Async} beans initialization.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "application.async")
public class AsyncConfigProperties implements InitializingBean {

    private int corePoolSize;

    private int maxPoolSize = 5;

    private int queueCapacity = 500;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (corePoolSize == 0) {
            corePoolSize = Math.max(Runtime.getRuntime().availableProcessors() / 10, 1);
        }
    }
}
