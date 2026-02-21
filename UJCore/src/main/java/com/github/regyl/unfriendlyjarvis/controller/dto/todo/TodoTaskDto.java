package com.github.regyl.unfriendlyjarvis.controller.dto.todo;

import com.github.regyl.unfriendlyjarvis.entity.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for TodoTask entity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoTaskDto {

    private Long id;

    private String title;

    private String description;

    private Boolean completed;

    private Priority priority;
}

