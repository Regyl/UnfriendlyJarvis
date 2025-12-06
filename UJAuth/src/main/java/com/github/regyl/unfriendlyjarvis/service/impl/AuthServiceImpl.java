package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.annotation.BusinessEvent;
import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.TokenResponseDto;
import com.github.regyl.unfriendlyjarvis.entity.UserEntity;
import com.github.regyl.unfriendlyjarvis.enumeration.EventType;
import com.github.regyl.unfriendlyjarvis.exceptiion.JarvisException;
import com.github.regyl.unfriendlyjarvis.exceptiion.UserAlreadyExistsException;
import com.github.regyl.unfriendlyjarvis.repository.UserRepository;
import com.github.regyl.unfriendlyjarvis.service.AuthService;
import com.github.regyl.unfriendlyjarvis.service.jwt.JwtTokenProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Service for simple username & password based authorization.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final String USER_NOT_FOUND_MESSAGE = "User with login %s not found";
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials";
    private static final String INVALID_REFRESH_TOKEN_MESSAGE = "Invalid refresh token";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Function<RegistrationDto, UserEntity> registrationDtoMapper;
    private final JwtTokenProviderService jwtProvider;

    @Override
    public boolean isUserExistsByUsername(String username) {
        return userRepository.existsByEmail(username);
    }

    @Override
    @BusinessEvent(type = EventType.REGISTRATION)
    public TokenResponseDto signUp(RegistrationDto registrationDto) {
        String username = registrationDto.getEmail();
        if (isUserExistsByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }

        UserEntity newUser = registrationDtoMapper.apply(registrationDto);
        UserEntity savedUser = userRepository.save(newUser);
        
        return generateTokens(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));
    }

    @Override
    public TokenResponseDto signIn(String username, String password) {
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new JarvisException(INVALID_CREDENTIALS_MESSAGE));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new JarvisException(INVALID_CREDENTIALS_MESSAGE);
        }

        return generateTokens(user);
    }

    @Override
    public TokenResponseDto refreshToken(String refreshToken) {
        if (!jwtProvider.validateToken(refreshToken)) {
            throw new JarvisException(INVALID_REFRESH_TOKEN_MESSAGE);
        }

        if (!jwtProvider.isRefreshToken(refreshToken)) {
            throw new JarvisException(INVALID_REFRESH_TOKEN_MESSAGE);
        }

        String username = jwtProvider.getUsernameFromToken(refreshToken);
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new JarvisException(INVALID_REFRESH_TOKEN_MESSAGE));

        return generateTokens(user);
    }

    /**
     * Generate access and refresh tokens for user.
     *
     * @param user user entity
     * @return token response DTO
     */
    private TokenResponseDto generateTokens(UserEntity user) {
        String accessToken = jwtProvider.generateAccessToken(user);
        String refreshToken = jwtProvider.generateRefreshToken(user);
        
        return new TokenResponseDto(accessToken, refreshToken, "Bearer");
    }
}
