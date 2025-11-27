package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.TokenResponseDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.OAuthInitializationDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.github.UserEmailDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.github.UserInfoDto;
import com.github.regyl.unfriendlyjarvis.entity.User;
import com.github.regyl.unfriendlyjarvis.enumeration.OAuthProviderType;
import com.github.regyl.unfriendlyjarvis.exceptiion.JarvisException;
import com.github.regyl.unfriendlyjarvis.exceptiion.UserNotFoundException;
import com.github.regyl.unfriendlyjarvis.feign.GitHubFeignClient;
import com.github.regyl.unfriendlyjarvis.repository.UserRepository;
import com.github.regyl.unfriendlyjarvis.service.AuthService;
import com.github.regyl.unfriendlyjarvis.service.impl.converter.UserInfoDtoToRegistrationDtoMapperServiceImpl;
import com.github.regyl.unfriendlyjarvis.service.impl.jwt.JwtTokenProviderServiceImpl;
import com.github.regyl.unfriendlyjarvis.service.jwt.JwtTokenProviderService;
import com.github.regyl.unfriendlyjarvis.service.oauth.OAuthAccessTokenAcquirer;
import com.github.regyl.unfriendlyjarvis.service.oauth.OAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Implementation of {@link OAuthService} for GitHub.
 */
@Slf4j
@Service
public class OAuthGitHubServiceImpl implements OAuthService {

    private final GitHubFeignClient gitHubFeignClient;
    private final BiFunction<UserInfoDto, String, RegistrationDto> regDtoMapper;
    private final AuthService authService;
    private final UserRepository userRepository;
    private final JwtTokenProviderService jwtProvider;
    private final OAuthAccessTokenAcquirer oAuthAccessTokenAcquirer;
    
    /**
     * Constructor.
     *
     * @param gitHubFeignClient         {@link GitHubFeignClient} for GitHub API.
     * @param regDtoMapper              {@link UserInfoDtoToRegistrationDtoMapperServiceImpl} for converting DTOs.
     * @param authService               {@link AuthService} for user management.
     * @param userRepository            {@link UserRepository} for user queries.
     * @param jwtProvider               {@link JwtTokenProviderServiceImpl} for token generation.
     * @param oAuthAccessTokenAcquirers {@link OAuthAccessTokenAcquirer} for acquiring access token.
     */
    public OAuthGitHubServiceImpl(GitHubFeignClient gitHubFeignClient,
                                  BiFunction<UserInfoDto, String, RegistrationDto> regDtoMapper,
                                  AuthService authService,
                                  UserRepository userRepository,
                                  JwtTokenProviderService jwtProvider,
                                  List<OAuthAccessTokenAcquirer> oAuthAccessTokenAcquirers) {
        this.gitHubFeignClient = gitHubFeignClient;
        this.regDtoMapper = regDtoMapper;
        this.authService = authService;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;

        OAuthProviderType providerType = getSupportedProvider();
        this.oAuthAccessTokenAcquirer = oAuthAccessTokenAcquirers.stream()
                .filter(acquirer -> providerType == acquirer.getSupportedProvider())
                .findFirst()
                .orElseThrow(() -> new JarvisException(
                        "Unsupported OAuth2.0 provider " + providerType.name()));
    }

    @Override
    public OAuthProviderType getSupportedProvider() {
        return OAuthProviderType.GitHub;
    }

    @Override
    public TokenResponseDto signIn(OAuthInitializationDto initializationDto) {
        String accessToken = oAuthAccessTokenAcquirer.acquire(initializationDto);
        List<UserEmailDto> emails = gitHubFeignClient.getUserEmails(accessToken);
        String email = getPrimaryEmail(emails);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));

        return generateTokens(user);
    }

    @Override
    public TokenResponseDto signUp(OAuthInitializationDto initializationDto) {
        String accessToken = oAuthAccessTokenAcquirer.acquire(initializationDto);
        UserInfoDto userInfoDto = gitHubFeignClient.getUserInfo(accessToken);
        List<UserEmailDto> emails = gitHubFeignClient.getUserEmails(accessToken);
        String email = getPrimaryEmail(emails);
        RegistrationDto registrationDto = regDtoMapper.apply(userInfoDto, email);
        return authService.signUp(registrationDto);
    }

    private String getPrimaryEmail(List<UserEmailDto> emails) {
        return emails.stream()
                .filter(item -> item.getPrimary() != null && item.getPrimary())
                .findFirst()
                .map(UserEmailDto::getEmail)
                .orElse(null);
    }

    /**
     * Generate access and refresh tokens for user.
     *
     * @param user user entity
     * @return token response DTO
     */
    private TokenResponseDto generateTokens(User user) {
        String accessToken = jwtProvider.generateAccessToken(user);
        String refreshToken = jwtProvider.generateRefreshToken(user);
        
        return new TokenResponseDto(accessToken, refreshToken, "Bearer");
    }
}
