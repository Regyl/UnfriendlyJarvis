package com.github.regyl.dto;

import com.github.regyl.model.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Dto which contains information about happened event
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private EventType eventType;

    private List<Variable> variables;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static final class Variable {

        private String name;

        private String value;
    }
}
