package com.github.regyl.unfriendlyjarvis.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Supported OAuth 2.0 providers.
 */
public enum OAuthProviderType {

    GitHub,
    
    Facebook,
    
    Twitter,

    ;

    public static OAuthProviderType fromName(String name) {
        return OAuthProviderType.valueOf(name);
    }
}
