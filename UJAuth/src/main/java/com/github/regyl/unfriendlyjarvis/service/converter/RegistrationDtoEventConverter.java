package com.github.regyl.unfriendlyjarvis.service.converter;

import com.github.regyl.unfriendlyjarvis.api.converter.EventConverter;
import com.github.regyl.unfriendlyjarvis.dto.EventDto;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
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
