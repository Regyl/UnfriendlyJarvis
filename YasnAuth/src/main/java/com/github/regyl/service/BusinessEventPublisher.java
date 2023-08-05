package com.github.regyl.service;

import com.github.regyl.annotation.BusinessEvent;
import com.github.regyl.api.ConvertableEvent;
import com.github.regyl.api.converter.EventConverter;
import com.github.regyl.dto.EventDto;
import com.github.regyl.utils.AspectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Asynchronous publisher of business-significant events.
 */
@Slf4j(topic = "BusinessEventPublisher")
@Aspect
@Component
@SuppressWarnings("unchecked")
public class BusinessEventPublisher<T extends ConvertableEvent> {

    private final Map<Class<T>, EventConverter<T>> eventConverterMap;

    /**
     * Constructor.
     *
     * @param eventConverters list of event converters
     */
    public BusinessEventPublisher(List<EventConverter<T>> eventConverters) {
        this.eventConverterMap = eventConverters.stream()
                .collect(Collectors.toUnmodifiableMap(
                        EventConverter::getSupportedClass, Function.identity()));
    }

    /**
     * Publish event.
     *
     * @param jp                join point
     * @param businessEvent     annotation with event type
     * @param convertableEvent  event DTO
     */
    @Async("defaultAsyncExecutor")
    @AfterReturning(value = "@annotation(businessEvent) && args(convertableEvent,..)", argNames = "jp,businessEvent,convertableEvent")
    public void handleEvent(JoinPoint jp, BusinessEvent businessEvent, ConvertableEvent convertableEvent) {
        log.debug("Event publisher called from {} with arguments {}", AspectUtils.getMethodName(jp), Arrays.toString(jp.getArgs()));
        EventConverter<T> eventConverter = eventConverterMap.get(convertableEvent.getClass());
        if (eventConverter == null) {
            log.warn("Event converter for class type {} is not present, skipping", convertableEvent.getClass().getSimpleName());
            return;
        }

        EventDto eventDto = eventConverter.convert((T) convertableEvent);
        eventDto.setEventType(businessEvent.type());
    }
}
