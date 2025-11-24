package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableConfigurationProperties
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.github.regyl.unfriendlyjarvis.configuration")
public class UnfriendlyJarvisCoreApplication {

    static void main(String[] args) {
        SpringApplication.run(UnfriendlyJarvisCoreApplication.class, args);
    }

}
