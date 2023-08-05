package com.github.regyl.unfriendlyjarvis.service;

import com.github.regyl.unfriendlyjarvis.api.AuthService;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Mock of {@link AuthService} for development testing.
 */
@Service
@ConditionalOnMissingBean(AuthServiceImpl.class)
public class AuthServiceMock implements AuthService {

    @Override
    public boolean isUserExistsByUsername(String username) {
        return Boolean.TRUE;
    }

    @Override
    public void signUp(RegistrationDto registrationDto) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User();
    }

    @Override
    public boolean signIn(String username, String password) {
        return Boolean.TRUE;
    }
}
