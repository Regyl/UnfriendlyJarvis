package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Application's start point.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class UnfriendlyJarvisAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfriendlyJarvisAuthApplication.class, args);
	}

}
