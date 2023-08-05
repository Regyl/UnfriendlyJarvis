package com.github.regyl.unfriendlyjarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableConfigServer
@EnableEurekaServer
@SpringBootApplication
public class UnfriendlyJarvisCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnfriendlyJarvisCloudConfigApplication.class, args);
    }

}
