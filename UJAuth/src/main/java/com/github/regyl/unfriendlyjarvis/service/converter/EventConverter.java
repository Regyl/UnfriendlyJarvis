package com.github.regyl.unfriendlyjarvis.service.converter;

import com.github.regyl.unfriendlyjarvis.controller.dto.EventDto;
import com.github.regyl.unfriendlyjarvis.model.ConvertableEvent;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * DTOs converter to {@link EventDto}.
 *
 * @param <T> target DTO
 */
public interface EventConverter<T extends ConvertableEvent> extends Supplier<Class<T>>, Function<T, EventDto> {
}
