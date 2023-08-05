package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class UnfriendlyJarvisCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfriendlyJarvisCoreApplication.class, args);
    }

}
