package com.github.regyl.api.feign;

import com.github.regyl.dto.oauth.github.UserInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "github-api", url = "https://api.github.com")
public interface GitHubFeignClient {

    @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserInfoDto getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);

    @GetMapping(value = "/user/emails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getUserEmails(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);
}
