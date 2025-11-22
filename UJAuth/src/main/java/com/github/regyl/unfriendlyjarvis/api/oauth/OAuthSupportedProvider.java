package com.github.regyl.unfriendlyjarvis.api.oauth;

import com.github.regyl.unfriendlyjarvis.entity.enums.OAuthProviderType;

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
