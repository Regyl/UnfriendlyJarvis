package com.github.regyl.unfriendlyjarvis.service.impl.converter;

import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.service.converter.EventConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * {@link EventConverter} for class {@link RegistrationDto}.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class RegistrationDtoEventConverter implements EventConverter<RegistrationDto> {

    @Override
    public Class<RegistrationDto> getSupportedClass() {
        return RegistrationDto.class;
    }
}
