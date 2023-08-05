package com.github.regyl.api.feign;

import com.github.regyl.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.dto.oauth.github.AccessTokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign client to access GitHub OAuth 2.0 authorization endpoint.
 */
@FeignClient(name = "github-oauth", url = "https://github.com/login/oauth")
public interface GitHubOAuthFeignClient {
    
    /**
     * Acquire user's access token with allowed scopes.
     *
     * @param requestDto    DTO to request GitHub access token
     * @return              DTO with user's access token and allowed scopes
     */
    @PostMapping(value = "/access_token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AccessTokenResponseDto getAccessToken(@RequestBody AccessTokenRequestDto requestDto);
}
