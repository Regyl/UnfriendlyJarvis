package com.github.regyl.service.converter;

import com.github.regyl.dto.RegistrationDto;
import com.github.regyl.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Converter from {@link RegistrationDto} to {@link User} entity.
 * <p>
 * Also encodes password
 */
@Service
@RequiredArgsConstructor
public class RegistrationDtoToUserConverterImpl extends AbstractNotNullConverter<RegistrationDto, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User convertNotNullParam(RegistrationDto source) {
        return User.builder()
                .email(source.getEmail())
                .login(source.getLogin())
                .password(passwordEncoder.encode(source.getPassword()))
                .build();
    }
}
