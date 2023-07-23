package com.github.regyl.service.converter;

import com.github.regyl.api.converter.DefaultConverter;
import jakarta.validation.constraints.NotNull;

public abstract class AbstractNotNullConverter<T, S> implements DefaultConverter<T, S> {

    @Override
    public S convert(@NotNull T source) {
        if (source == null) {
            throw new IllegalArgumentException(
                    String.format("Source of type %s should be not null", source.getClass())
            );
        }

        return convertNotNullParam(source);
    }

    public abstract S convertNotNullParam(T source);
}
