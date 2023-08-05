package com.github.regyl.api.converter;

import com.github.regyl.api.ConvertableEvent;
import com.github.regyl.dto.EventDto;
import jakarta.validation.constraints.NotNull;

/**
 * DTOs converter to {@link EventDto}.
 *
 * @param <T> target DTO
 */
public interface EventConverter<T extends ConvertableEvent> {

    /**
     * Get target DTO type.
     *
     * @return DTO type
     */
    Class<T> getSupportedClass();

    /**
     * Convert target DTO to {@link EventDto}.
     *
     * @param   dto target
     * @return  DTO with info about event
     */
    EventDto convert(@NotNull T dto);
}
