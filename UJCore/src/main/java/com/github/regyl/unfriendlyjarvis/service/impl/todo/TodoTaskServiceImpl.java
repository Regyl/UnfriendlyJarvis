package com.github.regyl.unfriendlyjarvis.service.impl.todo;

import com.github.regyl.unfriendlyjarvis.controller.dto.todo.TodoTaskDto;
import com.github.regyl.unfriendlyjarvis.entity.TodoTaskEntity;
import com.github.regyl.unfriendlyjarvis.exception.JarvisException;
import com.github.regyl.unfriendlyjarvis.repository.TodoTaskRepository;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.todo.TodoTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.function.Function;

/**
 * Implementation of TodoTaskService.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TodoTaskServiceImpl implements TodoTaskService {

    private final TodoTaskRepository repository;
    private final SecurityContextService securityContextService;
    private final Function<TodoTaskEntity, TodoTaskDto> entityToDtoMapper;
    private final Function<TodoTaskDto, TodoTaskEntity> dtoToEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public Collection<TodoTaskDto> findAll() {
        Long accountId = securityContextService.getUserId();
        return repository.findAllByAccountId(accountId).stream()
                .map(entityToDtoMapper)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TodoTaskEntity findById(Long id) {
        Long accountId = securityContextService.getUserId();
        return repository.findByIdAndAccountId(id, accountId).orElseThrow(() -> new JarvisException("Task not found with id: " + id));
    }

    @Override
    @Transactional
    public TodoTaskDto create(TodoTaskDto dto) {
        if (dto.getId() != null) {
            throw new JarvisException("Task id must be null for creation");
        }

        TodoTaskEntity entity = dtoToEntityMapper.apply(dto);
        TodoTaskEntity saved = repository.save(entity);
        return entityToDtoMapper.apply(saved);
    }

    @Override
    @Transactional
    public TodoTaskDto update(Long id, TodoTaskDto dto) {
        TodoTaskEntity existing = findById(id);

        // Update fields
        if (dto.getTitle() != null) {
            existing.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            existing.setDescription(dto.getDescription());
        }
        if (dto.getCompleted() != null) {
            existing.setCompleted(dto.getCompleted());
        }
        if (dto.getPriority() != null) {
            existing.setPriority(dto.getPriority());
        }

        TodoTaskEntity updated = repository.save(existing);
        return entityToDtoMapper.apply(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        TodoTaskEntity entity = findById(id);
        repository.delete(entity);
    }
}
