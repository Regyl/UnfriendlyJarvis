package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.TodoTaskEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for TodoTaskEntity.
 */
@Repository
public interface TodoTaskRepository extends AbstractRepository<TodoTaskEntity> {

    /**
     * Find task by id and account id.
     *
     * @param id        task id
     * @param accountId account id
     * @return optional task entity
     */
    Optional<TodoTaskEntity> findByIdAndAccountId(Long id, Long accountId);
}

