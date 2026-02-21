package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long> {

    void deleteAllByAccountIdAndSource(Long accountId, Source source);

    Collection<T> findAllByAccountId(Long accountId);
}
