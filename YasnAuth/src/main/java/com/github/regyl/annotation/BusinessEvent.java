package com.github.regyl.annotation;

import com.github.regyl.model.enums.EventType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to process business-significant events.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BusinessEvent {

    /**
     * Event type.
     *
     * @return type of event
     */
    EventType type();
}
