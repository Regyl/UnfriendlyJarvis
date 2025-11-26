package com.github.regyl.unfriendlyjarvis.enumeration;

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
