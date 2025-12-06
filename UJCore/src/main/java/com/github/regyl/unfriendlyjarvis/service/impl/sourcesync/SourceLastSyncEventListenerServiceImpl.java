package com.github.regyl.unfriendlyjarvis.service.impl.sourcesync;

import com.github.regyl.unfriendlyjarvis.entity.SourceLastSyncEntity;
import com.github.regyl.unfriendlyjarvis.model.event.SourceLastSyncEvent;
import com.github.regyl.unfriendlyjarvis.repository.SourceLastSyncRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class SourceLastSyncEventListenerServiceImpl implements ApplicationListener<SourceLastSyncEvent> {

    private final SourceLastSyncRepository repository;
    private final Function<SourceLastSyncEvent, SourceLastSyncEntity> entityMapper;

    @Async
    @Override
    @Transactional
    public void onApplicationEvent(@NotNull SourceLastSyncEvent event) {
        SourceLastSyncEntity entity = entityMapper.apply(event);

        repository.deleteByAccountId(entity.getAccountId());
        repository.save(entity);
    }
}
