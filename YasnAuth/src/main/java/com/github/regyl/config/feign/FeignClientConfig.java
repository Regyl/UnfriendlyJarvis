package com.github.regyl.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Feign client base configuration.
 */
@Configuration
@EnableFeignClients(basePackages = {"com.github.regyl.api.feign"})
public class FeignClientConfig {

}

