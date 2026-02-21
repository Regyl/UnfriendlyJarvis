package com.github.regyl.unfriendlyjarvis.service.impl.sourcesync.mapper;

import com.github.regyl.unfriendlyjarvis.entity.SourceLastSyncEntity;
import com.github.regyl.unfriendlyjarvis.model.SourceLastSyncModel;
import com.github.regyl.unfriendlyjarvis.model.event.SourceLastSyncEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class SourceLastSyncEventToEntityMapperServiceImpl implements Function<SourceLastSyncEvent, SourceLastSyncEntity> {

    private final Supplier<OffsetDateTime> dateTimeSupplier;

    @Override
    public SourceLastSyncEntity apply(SourceLastSyncEvent event) {
        SourceLastSyncModel model = event.getSource();

        return SourceLastSyncEntity.builder()
                .lastSyncDate(model.getLastSyncDate())
                .accountId(model.getAccountId())
                .source(model.getSource())
                .created(dateTimeSupplier.get())
                .build();
    }
}
