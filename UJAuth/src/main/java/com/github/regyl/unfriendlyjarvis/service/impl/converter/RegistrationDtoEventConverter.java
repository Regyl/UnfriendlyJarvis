package com.github.regyl.unfriendlyjarvis.service.impl.converter;

import com.github.regyl.unfriendlyjarvis.controller.dto.EventDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.enumeration.EventType;
import com.github.regyl.unfriendlyjarvis.service.converter.EventConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * {@link EventConverter} for class {@link RegistrationDto}.
 */
@Component
@RequiredArgsConstructor
public class RegistrationDtoEventConverter implements EventConverter<RegistrationDto> {

    @Override
    public Class<RegistrationDto> get() {
        return RegistrationDto.class;
    }

    @Override
    public EventDto apply(RegistrationDto dto) {
        return EventDto.builder()
                .eventType(EventType.REGISTRATION)
                .build();
    }
}
