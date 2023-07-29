package com.github.regyl.service.converter;

import com.github.regyl.api.converter.EventConverter;
import com.github.regyl.dto.EventDto;
import com.github.regyl.dto.RegistrationDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * {@link EventConverter} for class {@link RegistrationDto}.
 */
@Component
public class RegistrationDtoEventConverter implements EventConverter<RegistrationDto> {

    @Override
    public Class<RegistrationDto> getSupportedClass() {
        return RegistrationDto.class;
    }

    @Override
    public EventDto convert(@NotNull RegistrationDto dto) {
        return new EventDto();
    }
}
