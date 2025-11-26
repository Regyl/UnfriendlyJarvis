package com.github.regyl.unfriendlyjarvis.service.oauth;

import com.github.regyl.unfriendlyjarvis.controller.dto.TokenResponseDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.OAuthInitializationDto;

/**
 * OAuth 2.0 authorization service.
 */
public interface OAuthService extends OAuthSupportedProvider {
    
    /**
     * Check if user exists and generate tokens.
     *
     * @param initializationDto DTO with information to initialize OAuth 2.0 authorization
     * @return                   JWT tokens (access and refresh) if user exists, null otherwise
     */
    TokenResponseDto signIn(OAuthInitializationDto initializationDto);
    
    /**
     * Sign up user and generate tokens.
     *
     * @param initializationDto DTO with information to initialize OAuth 2.0 authorization
     * @return                  JWT tokens (access and refresh)
     */
    TokenResponseDto signUp(OAuthInitializationDto initializationDto);
}
