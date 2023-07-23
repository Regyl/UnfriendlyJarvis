package com.github.regyl.api.converter;

import jakarta.validation.constraints.NotNull;

/**
 * Converter from source {@link T} to target type {@link S}.
 *
 * @param <T> source type
 * @param <S> target type
 */
public interface DefaultConverter<T, S> {

    /**
     * Convert from source {@link T} to target type {@link S}.
     *
     * @param source {@link T} dto
     * @return {@link S} target entity
     */
    S convert(@NotNull T source);
}
