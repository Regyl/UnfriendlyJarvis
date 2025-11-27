package com.github.regyl.unfriendlyjarvis.enumeration;

import lombok.Getter;

/**
 * Enumeration of user secret data keys.
 * Keys must not exceed 128 characters.
 */
@Getter
public enum UserSecretKey {
    
    /**
     * API key for external service integration.
     */
    API_KEY("api_key"),
    
    /**
     * Unique identifier in GitHub service.
     */
    GITHUB_USER_ID("github_user_id"),
    
    YANDEX_MUSIC_USER_ID("yandex_music_user_id"),

    ;
    
    private final String key;
    
    UserSecretKey(String key) {
        if (key.length() > 128) {
            throw new IllegalArgumentException("Key length must not exceed 128 characters");
        }
        this.key = key;
    }
}

