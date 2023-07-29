package com.github.regyl.api.converter;

import com.github.regyl.annotation.ConvertableEvent;
import com.github.regyl.dto.EventDto;
import jakarta.validation.constraints.NotNull;

/**
 * Dtos converter to {@link EventDto}.
 *
 * @param <T> target dto
 */
public interface EventConverter<T extends ConvertableEvent> {

    /**
     * Get target dto type.
     *
     * @return dto type
     */
    Class<T> getSupportedClass();

    /**
     * Convert target dto to {@link EventDto}.
     *
     * @param   dto target
     * @return  dto with info about event
     */
    EventDto convert(@NotNull T dto);
}
