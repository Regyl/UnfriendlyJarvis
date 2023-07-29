package com.github.regyl.service;

import com.github.regyl.annotation.BusinessEvent;
import com.github.regyl.api.AuthService;
import com.github.regyl.api.converter.DefaultConverter;
import com.github.regyl.dto.RegistrationDto;
import com.github.regyl.exceptiion.UserAlreadyExistsException;
import com.github.regyl.model.User;
import com.github.regyl.model.enums.EventType;
import com.github.regyl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service for simple username & password - based authentication.
 */
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "application.security", name = "enabled", havingValue = "true", matchIfMissing = true)
public class AuthServiceImpl implements AuthService {

    private static final String USER_NOT_FOUND_MESSAGE = "User with login %s not found";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DefaultConverter<RegistrationDto, User> registrationDtoUserDefaultConverter;

    @Override
    public boolean isUserExistsByUsername(String username) {
        return userRepository.existsByEmail(username);
    }

    @Override
    @BusinessEvent(type = EventType.REGISTRATION)
    public void saveNewUser(RegistrationDto registrationDto) {
        String username = registrationDto.getEmail();
        if (isUserExistsByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }

        User newUser = registrationDtoUserDefaultConverter.convert(registrationDto);
        userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));
    }

    @Override
    public boolean signIn(String username, String password) {
        String hashedPassword = userRepository.findPasswordByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));

        return passwordEncoder.matches(password, hashedPassword);
    }
}
