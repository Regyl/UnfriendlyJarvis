package com.github.regyl.unfriendlyjarvis.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Feign client base configuration.
 */
@Configuration
@EnableFeignClients(basePackages = {"com.github.regyl.unfriendlyjarvis.api.feign"})
public class FeignClientConfig {

}

