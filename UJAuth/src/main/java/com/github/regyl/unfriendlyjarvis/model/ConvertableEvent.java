package com.github.regyl.unfriendlyjarvis.model;

import com.github.regyl.unfriendlyjarvis.service.converter.EventConverter;
import com.github.regyl.unfriendlyjarvis.controller.dto.EventDto;

/**
 * DTO able to be converted to {@link EventDto}.
 *
 * <p>
 * Marker interface.
 * See also implementations of {@link EventConverter}.
 */
public interface ConvertableEvent {
}
