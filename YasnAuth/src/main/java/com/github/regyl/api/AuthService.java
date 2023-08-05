package com.github.regyl.api;

import com.github.regyl.dto.RegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Simple authorization service.
 */
public interface AuthService extends UserDetailsService {

    /**
     * Check is user exists by username.
     *
     * @param username user's login
     * @return         flag is user exists
     */
    boolean isUserExistsByUsername(String username);

    /**
     * Check and create new user record.
     *
     * @param registrationDto DTO with user's information
     */
    void signUp(RegistrationDto registrationDto);

    /**
     * Validate credentials.
     *
     * @param username user's username
     * @param password user's password
     * @return         flag are credentials valid
     */
    boolean signIn(String username, String password);
}
