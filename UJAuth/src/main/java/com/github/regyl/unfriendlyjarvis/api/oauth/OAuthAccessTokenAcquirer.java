package com.github.regyl.unfriendlyjarvis.api.oauth;

import com.github.regyl.unfriendlyjarvis.dto.oauth.OAuthInitializationDto;

/**
 * OAuth 2.0 access token acquirer.
 */
public interface OAuthAccessTokenAcquirer extends OAuthSupportedProvider {
    
    /**
     * Get user's access token.
     *
     * @param initializationDto DTO with information to initialize OAuth 2.0 authorization
     * @return                  authorization token
     */
    String acquire(OAuthInitializationDto initializationDto);
}
