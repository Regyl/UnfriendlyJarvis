package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Application's start point.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "com.github.regyl.unfriendlyjarvis.configuration")
public class UnfriendlyJarvisAuthApplication {

    static void main(String[] args) {
        SpringApplication.run(UnfriendlyJarvisAuthApplication.class, args);
    }

}
