package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.TokenResponseDto;
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
     * @return                JWT tokens (access and refresh)
     */
    TokenResponseDto signUp(RegistrationDto registrationDto);

    /**
     * Validate credentials and generate JWT tokens.
     *
     * @param username user's username
     * @param password user's password
     * @return         JWT tokens (access and refresh)
     */
    TokenResponseDto signIn(String username, String password);

    /**
     * Refresh access token using refresh token.
     *
     * @param refreshToken refresh token
     * @return             new JWT tokens (access and refresh)
     */
    TokenResponseDto refreshToken(String refreshToken);
}
