package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "com.github.regyl.unfriendlyjarvis.configuration")
public class UnfriendlyJarvisCoreApplication {

    static void main(String[] args) {
        SpringApplication.run(UnfriendlyJarvisCoreApplication.class, args);
    }

}
