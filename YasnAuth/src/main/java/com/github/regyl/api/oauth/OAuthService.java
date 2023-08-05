package com.github.regyl.api.oauth;

import com.github.regyl.dto.oauth.OAuthInitializationDto;

/**
 * OAuth 2.0 authorization service.
 */
public interface OAuthService extends OAuthSupportedProvider {
    
    /**
     * Check if user exists.
     *
     * @param initializationDto DTO with information to initialize OAuth 2.0 authorization
     * @return                  true if user exists, false otherwise
     */
    boolean exists(OAuthInitializationDto initializationDto);
    
    /**
     * Sign up user.
     *
     * @param initializationDto DTO with information to initialize OAuth 2.0 authorization
     */
    void signUp(OAuthInitializationDto initializationDto);
}
