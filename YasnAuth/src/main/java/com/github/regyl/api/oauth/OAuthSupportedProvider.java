package com.github.regyl.api.oauth;

import com.github.regyl.model.enums.OAuthProviderType;

/**
 * OAuth 2.0 provider implementation.
 */
public interface OAuthSupportedProvider {
    
    /**
     * Get service supported {@link OAuthProviderType} provider.
     *
     * @return OAuth provider type
     */
    OAuthProviderType getSupportedProvider();
}
