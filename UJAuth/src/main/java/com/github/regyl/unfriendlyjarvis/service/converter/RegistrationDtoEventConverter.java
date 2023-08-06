package com.github.regyl.unfriendlyjarvis.service.converter;

import com.github.regyl.unfriendlyjarvis.api.converter.EventConverter;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
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
