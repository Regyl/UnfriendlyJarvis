package com.github.regyl.unfriendlyjarvis.service.impl.yandexmusic;

import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.Artist;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.TrackInfo;
import com.github.regyl.unfriendlyjarvis.model.TrackModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TrackInfoToTrackModelMapperServiceImpl implements Function<TrackInfo, TrackModel> {

    @Override
    public TrackModel apply(TrackInfo trackInfo) {
        String artistNames = trackInfo.getArtists().stream()
                .map(Artist::getName)
                .reduce((item1, item2) -> String.join(", ", item1, item2))
                .orElse("");

        return TrackModel.builder()
                .name(trackInfo.getTitle())
                .artistName(artistNames)
                .coverUrl(trackInfo.getCoverUri())
                .build();
    }
}
