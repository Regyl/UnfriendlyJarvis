package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

/**
 * Interface for generic CRUD operations on a repository for a specific type.
 *
 * @param <T> the type of entities managed by the repository
 */
@NoRepositoryBean
public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, UUID> {
}
