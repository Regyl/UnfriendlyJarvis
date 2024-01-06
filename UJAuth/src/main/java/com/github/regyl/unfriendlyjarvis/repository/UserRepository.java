package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for querying {@link User} data.
 */
@Repository
public interface UserRepository extends AbstractRepository<User> {
    
    /**
     * Check if exists a {@link User} with the given email.
     *
     * @param email {@link User} email.
     * @return      true if exists a {@link User} with the given email.
     */
    boolean existsByEmail(String email);

    /**
     * Find a {@link User} by the given email.
     *
     * @param email {@link User} email.
     * @return      {@link User} with the given email.
     */
    Optional<User> findByEmail(String email);
}
