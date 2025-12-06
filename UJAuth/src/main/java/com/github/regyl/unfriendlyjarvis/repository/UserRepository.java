package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for querying {@link UserEntity} data.
 */
@Repository
public interface UserRepository extends AbstractRepository<UserEntity> {
    
    /**
     * Check if exists a {@link UserEntity} with the given email.
     *
     * @param email {@link UserEntity} email.
     * @return      true if exists a {@link UserEntity} with the given email.
     */
    boolean existsByEmail(String email);

    /**
     * Find a {@link UserEntity} by the given email.
     *
     * @param email {@link UserEntity} email.
     * @return      {@link UserEntity} with the given email.
     */
    Optional<UserEntity> findByEmail(String email);
}
