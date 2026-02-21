package com.github.regyl.unfriendlyjarvis.service.usersecretdata;

import java.util.Map;
import java.util.Optional;

/**
 * Service for retrieving user secret data via gRPC.
 */
public interface UserSecretDataService {
    
    /**
     * Get secret data value by user ID and key.
     *
     * @param userId User ID.
     * @param key    Secret key (enum value as string).
     * @return Optional containing the secret value if found, empty otherwise.
     */
    Optional<String> getSecretData(Long userId, String key);
    
    /**
     * Get all secret data for a user.
     *
     * @param userId User ID.
     * @return Map of key-value pairs, empty map if user not found or has no secret data.
     */
    Map<String, String> getAllSecretData(Long userId);
}

