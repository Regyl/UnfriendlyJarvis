package com.github.regyl.unfriendlyjarvis.repository;

import com.github.regyl.unfriendlyjarvis.entity.SourceLastSyncEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SourceLastSyncRepository extends AbstractRepository<SourceLastSyncEntity> {

    void deleteByAccountId(Long accountId);

    Optional<SourceLastSyncEntity> findByAccountIdAndSource(Long accountId, Source source);
}
