package com.github.regyl.unfriendlyjarvis.service.impl.yandexmusic;

import com.github.regyl.unfriendlyjarvis.entity.TrackEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.model.TrackModel;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class TrackModelToTrackEntityMapperServiceImpl implements Function<TrackModel, TrackEntity> {

    private final Supplier<OffsetDateTime> dateTimeSupplier;
    private final SecurityContextService securityContextService;

    @Override
    public TrackEntity apply(TrackModel trackModel) {
        return TrackEntity.builder()
                .name(trackModel.getName())
                .artistName(trackModel.getArtistName())
                .coverUrl(trackModel.getCoverUrl())
                .source(Source.YANDEX_MUSIC)
                .accountId(securityContextService.getUserId())
                .created(dateTimeSupplier.get())
                .build();
    }
}
