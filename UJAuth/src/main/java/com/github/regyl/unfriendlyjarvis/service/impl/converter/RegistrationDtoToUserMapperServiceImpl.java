package com.github.regyl.unfriendlyjarvis.service.impl.converter;

import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Converter from {@link RegistrationDto} to {@link User} entity.
 *
 * <p>
 * Also encodes password.
 */
@Component
@RequiredArgsConstructor
public class RegistrationDtoToUserMapperServiceImpl implements Function<RegistrationDto, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User apply(RegistrationDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.login( dto.getLogin() );
        user.email( dto.getEmail() );
        user.accountNonLocked(true);

        String pwd = dto.getPassword();
        if (!StringUtils.isEmpty(pwd)) {
            user.password(passwordEncoder.encode(pwd));
        }

        return user.build();
    }
}
