package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.User;
import com.github.regyl.unfriendlyjarvis.entity.UserSecretData;
import com.github.regyl.unfriendlyjarvis.enumeration.UserSecretKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for querying {@link UserSecretData} entities.
 */
@Repository
public interface UserSecretDataRepository extends AbstractRepository<UserSecretData> {
    
    /**
     * Find all secret data entries for a specific user.
     *
     * @param userId User ID.
     * @return List of user secret data entries.
     */
    List<UserSecretData> findByUser_Id(Long userId);
    
    /**
     * Find secret data entry by user and key.
     *
     * @param user User entity.
     * @param key  Secret key.
     * @return Optional secret data entry.
     */
    Optional<UserSecretData> findByUserAndKey(User user, UserSecretKey key);
    
    /**
     * Check if secret data entry exists for user and key.
     *
     * @param userId User ID.
     * @param key    Secret key.
     * @return true if entry exists.
     */
    boolean existsByUser_IdAndKey(Long userId, UserSecretKey key);
    
    /**
     * Delete all secret data entries for a specific user.
     *
     * @param userId User ID.
     */
    void deleteByUser_Id(Long userId);
}

