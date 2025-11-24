package com.github.regyl.unfriendlyjarvis.service.impl.converter;

import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Converter from {@link RegistrationDto} to {@link User} entity.
 *
 * <p>
 * Also encodes password.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class RegistrationDtoMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;
    
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registrationDto.getPassword()))")
    public abstract User convert(RegistrationDto registrationDto);
}
