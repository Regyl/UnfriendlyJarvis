package com.github.regyl.service;

import com.github.regyl.api.AuthService;
import com.github.regyl.api.oauth.OAuthAccessTokenAcquirer;
import com.github.regyl.api.oauth.OAuthService;
import com.github.regyl.api.converter.GitHubConverter;
import com.github.regyl.api.feign.GitHubFeignClient;
import com.github.regyl.dto.RegistrationDto;
import com.github.regyl.dto.oauth.OAuthInitializationDto;
import com.github.regyl.dto.oauth.github.UserInfoDto;
import com.github.regyl.exceptiion.JarvisException;
import com.github.regyl.exceptiion.UserAlreadyExistsException;
import com.github.regyl.model.enums.OAuthProviderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link OAuthService} for GitHub.
 */
@Slf4j
@Service
public class OAuthGitHubServiceImpl implements OAuthService {

    private final GitHubFeignClient gitHubFeignClient;
    private final GitHubConverter gitHubConverter;
    private final AuthService authService;
    private final OAuthAccessTokenAcquirer oAuthAccessTokenAcquirer;
    
    /**
     * Constructor.
     *
     * @param gitHubFeignClient         {@link GitHubFeignClient} for GitHub API.
     * @param gitHubConverter           {@link GitHubConverter} for converting DTOs.
     * @param authService               {@link AuthService} for user management.
     * @param oAuthAccessTokenAcquirers {@link OAuthAccessTokenAcquirer} for acquiring access token.
     */
    public OAuthGitHubServiceImpl(GitHubFeignClient gitHubFeignClient, GitHubConverter gitHubConverter, AuthService authService, List<OAuthAccessTokenAcquirer> oAuthAccessTokenAcquirers) {
        this.gitHubFeignClient = gitHubFeignClient;
        this.gitHubConverter = gitHubConverter;
        this.authService = authService;

        OAuthProviderType providerType = getSupportedProvider();
        this.oAuthAccessTokenAcquirer = oAuthAccessTokenAcquirers.stream()
                .filter(acquirer -> providerType == acquirer.getSupportedProvider())
                .findFirst()
                .orElseThrow(() -> new JarvisException("Unsupported OAuth2.0 provider " + providerType.name()));
    }

    @Override
    public OAuthProviderType getSupportedProvider() {
        return OAuthProviderType.GitHub;
    }

    @Override
    public boolean exists(OAuthInitializationDto initializationDto) {
        String accessToken = oAuthAccessTokenAcquirer.acquire(initializationDto);
        UserInfoDto userInfoDto = gitHubFeignClient.getUserInfo(accessToken);
        return authService.isUserExistsByUsername(userInfoDto.getLogin());
    }

    @Override
    public void signUp(OAuthInitializationDto initializationDto) {
        String accessToken = oAuthAccessTokenAcquirer.acquire(initializationDto);
        UserInfoDto userInfoDto = gitHubFeignClient.getUserInfo(accessToken);
        if (authService.isUserExistsByUsername(userInfoDto.getLogin())) {
            throw new UserAlreadyExistsException("Found existing user");
        }

        RegistrationDto registrationDto = gitHubConverter.convert(userInfoDto);
        authService.signUp(registrationDto);
    }
}
