package com.github.regyl.unfriendlyjarvis.service.impl.todo;

import com.github.regyl.unfriendlyjarvis.controller.dto.todo.TodoTaskDto;
import com.github.regyl.unfriendlyjarvis.entity.TodoTaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Mapper from TodoTaskEntity to TodoTaskDto.
 */
@Component
@RequiredArgsConstructor
public class TodoTaskEntityToDtoMapperServiceImpl implements Function<TodoTaskEntity, TodoTaskDto> {

    @Override
    public TodoTaskDto apply(TodoTaskEntity entity) {
        return TodoTaskDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .completed(entity.getCompleted())
                .priority(entity.getPriority())
                .build();
    }
}
