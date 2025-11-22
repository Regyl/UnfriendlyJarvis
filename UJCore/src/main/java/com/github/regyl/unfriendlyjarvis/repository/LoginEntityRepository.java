package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.entity.LoginEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LoginEntityRepository extends AbstractRepository<LoginEntity> {

    void deleteAllByAccountAndSource(Account account, Source source);

    Collection<LoginEntity> findAllByAccount(Account account);
}
