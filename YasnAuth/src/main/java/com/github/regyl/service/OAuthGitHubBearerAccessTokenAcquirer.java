package com.github.regyl.service;

import com.github.regyl.api.oauth.OAuthAccessTokenAcquirer;
import com.github.regyl.api.converter.GitHubConverter;
import com.github.regyl.api.feign.GitHubOAuthFeignClient;
import com.github.regyl.dto.oauth.OAuthInitializationDto;
import com.github.regyl.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.dto.oauth.github.AccessTokenResponseDto;
import com.github.regyl.exceptiion.JarvisException;
import com.github.regyl.model.enums.OAuthProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthGitHubBearerAccessTokenAcquirer implements OAuthAccessTokenAcquirer {

    private static final String DEFAULT_TOKEN_TYPE = "Bearer";

    private final GitHubConverter gitHubConverter;
    private final GitHubOAuthFeignClient gitHubOAuthFeignClient;

    @Override
    public String acquire(OAuthInitializationDto initializationDto) {
        AccessTokenRequestDto accessTokenRequestDto = gitHubConverter.convert(initializationDto);
        AccessTokenResponseDto accessTokenResponseDto = gitHubOAuthFeignClient.getAccessToken(accessTokenRequestDto);
        if (!DEFAULT_TOKEN_TYPE.equalsIgnoreCase(accessTokenResponseDto.getTokenType())) {
            String exMessage = String.format("OAuth through service %s currently unavailable",
                    initializationDto.getOAuthProviderType().name());
            throw new JarvisException(exMessage);
        }

        return String.join(" ", DEFAULT_TOKEN_TYPE, accessTokenResponseDto.getAccessToken());
    }

    @Override
    public OAuthProviderType getSupportedProvider() {
        return OAuthProviderType.GitHub;
    }
}
