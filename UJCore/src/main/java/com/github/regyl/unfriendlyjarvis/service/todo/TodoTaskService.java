package com.github.regyl.unfriendlyjarvis.service.todo;

import com.github.regyl.unfriendlyjarvis.controller.dto.todo.TodoTaskDto;
import com.github.regyl.unfriendlyjarvis.entity.TodoTaskEntity;

import java.util.Collection;

/**
 * Service for working with to-do tasks.
 */
public interface TodoTaskService {

    /**
     * Get all tasks for current user.
     *
     * @return collection of task DTOs
     */
    Collection<TodoTaskDto> findAll();

    /**
     * Get task by id for current user.
     *
     * @param id task id
     * @return optional task DTO
     */
    TodoTaskEntity findById(Long id);

    /**
     * Create new task.
     *
     * @param dto task DTO
     * @return created task DTO
     */
    TodoTaskDto create(TodoTaskDto dto);

    /**
     * Update existing task.
     *
     * @param id  task id
     * @param dto task DTO with updated data
     * @return updated task DTO
     */
    TodoTaskDto update(Long id, TodoTaskDto dto);

    /**
     * Delete task by id.
     *
     * @param id task id
     */
    void delete(Long id);
}
