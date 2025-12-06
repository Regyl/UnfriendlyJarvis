package com.github.regyl.unfriendlyjarvis.aspect;

import com.github.regyl.unfriendlyjarvis.annotation.SourceSynced;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.model.SourceLastSyncModel;
import com.github.regyl.unfriendlyjarvis.model.event.SourceLastSyncEvent;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Supplier;

@Aspect
@Component
@RequiredArgsConstructor
public class SourceSyncAspect {

    private final Supplier<LocalDate> dateSupplier;
    private final SecurityContextService securityContextService;
    private final ApplicationEventPublisher eventPublisher;

    @AfterReturning("@annotation(annotation)")
    public void afterReturning(SourceSynced annotation) {
        Source source = annotation.source();
        Long accountId = securityContextService.getUserId();
        SourceLastSyncModel model = SourceLastSyncModel.builder()
                .lastSyncDate(dateSupplier.get())
                .accountId(accountId)
                .source(source)
                .build();

        eventPublisher.publishEvent(new SourceLastSyncEvent(model));
    }
}
