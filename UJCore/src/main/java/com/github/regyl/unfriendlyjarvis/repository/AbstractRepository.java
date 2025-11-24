package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.entity.TrackEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.UUID;

@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long> {

    void deleteAllByAccountAndSource(Account account, Source source);

    Collection<T> findAllByAccount(Account account);
}
