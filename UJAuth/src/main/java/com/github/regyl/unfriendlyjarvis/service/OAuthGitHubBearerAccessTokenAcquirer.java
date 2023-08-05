package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.api.converter.GitHubConverter;
import com.github.regyl.unfriendlyjarvis.api.feign.GitHubOAuthFeignClient;
import com.github.regyl.unfriendlyjarvis.api.oauth.OAuthAccessTokenAcquirer;
import com.github.regyl.unfriendlyjarvis.dto.oauth.OAuthInitializationDto;
import com.github.regyl.unfriendlyjarvis.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.unfriendlyjarvis.dto.oauth.github.AccessTokenResponseDto;
import com.github.regyl.unfriendlyjarvis.exceptiion.JarvisException;
import com.github.regyl.unfriendlyjarvis.model.enums.OAuthProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation for acquiring GitHub <a href="https://oauth.net/2/bearer-tokens/">bearer</a> token.
 * <p>
 * See also GitHub <a href="https://docs.github.com/en/apps/oauth-apps/building-oauth-apps/authorizing-oauth-apps">OAuth documentation</a>.
 */
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
