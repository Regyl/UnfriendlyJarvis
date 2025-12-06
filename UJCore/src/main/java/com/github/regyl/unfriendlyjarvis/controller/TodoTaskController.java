package com.github.regyl.unfriendlyjarvis.controller;

import com.github.regyl.unfriendlyjarvis.controller.dto.todo.TodoTaskDto;
import com.github.regyl.unfriendlyjarvis.service.todo.TodoTaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller for to-do task management.
 */
@RestController
@RequestMapping("/todo-tasks")
@RequiredArgsConstructor
public class TodoTaskController {

    private final TodoTaskService service;

    /**
     * Get all tasks for current user.
     *
     * @return collection of task DTOs
     */
    @GetMapping
    public Collection<TodoTaskDto> findAll() {
        return service.findAll();
    }

    /**
     * Create new task.
     *
     * @param dto task DTO
     * @return created task DTO
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoTaskDto create(@Valid @RequestBody TodoTaskDto dto) {
        return service.create(dto);
    }

    /**
     * Update existing task.
     *
     * @param id  task id
     * @param dto task DTO with updated data
     * @return updated task DTO or 404 if not found
     */
    @PatchMapping("/{id}")
    public TodoTaskDto update(@PathVariable Long id,
                                              @Valid @RequestBody TodoTaskDto dto) {
        return service.update(id, dto);
    }

    /**
     * Delete task by id.
     *
     * @param id task id
     * @return 204 No Content or 404 if not found
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

