package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.controller.dto.TokenResponseDto;
import com.github.regyl.unfriendlyjarvis.service.AuthService;
import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Mock of {@link AuthService} for development testing.
 */
@Component
@ConditionalOnMissingBean(AuthServiceImpl.class)
public class AuthServiceMock implements AuthService {

    @Override
    public boolean isUserExistsByUsername(String username) {
        return Boolean.TRUE;
    }

    @Override
    public TokenResponseDto signUp(RegistrationDto registrationDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User();
    }

    @Override
    public TokenResponseDto signIn(String username, String password) {
        return null;
    }

    @Override
    public TokenResponseDto refreshToken(String refreshToken) {
        return null;
    }
}
