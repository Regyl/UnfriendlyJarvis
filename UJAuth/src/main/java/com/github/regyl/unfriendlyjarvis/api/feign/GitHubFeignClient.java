package com.github.regyl.unfriendlyjarvis.api.feign;

import com.github.regyl.unfriendlyjarvis.dto.oauth.github.UserInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * Feign client to access GitHub API.
 *
 * <p>
 * See also <a href="https://docs.github.com/en/rest/users?apiVersion=2022-11-28">GitHub API</a>
 */
@FeignClient(name = "github-api", url = "https://api.github.com")
public interface GitHubFeignClient {
    
    /**
     * Acquire user info.
     *
     * @param accessToken   user's access token
     * @return              DTO with GitHub user's information
     */
    @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserInfoDto getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);
    
    /**
     * Acquire user emails.
     *
     * @param accessToken   user's access token
     * @return              list of user's emails
     */
    @GetMapping(value = "/user/emails", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<String> getUserEmails(@RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken);
}
