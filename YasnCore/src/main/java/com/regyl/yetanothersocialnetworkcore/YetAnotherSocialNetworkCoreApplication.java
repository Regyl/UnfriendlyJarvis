package com.regyl.yetanothersocialnetworkcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class YetAnotherSocialNetworkCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(YetAnotherSocialNetworkCoreApplication.class, args);
    }

}
