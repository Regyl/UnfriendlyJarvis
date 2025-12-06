package com.github.regyl.unfriendlyjarvis.service.impl.yandexmusic;

import com.github.regyl.unfriendlyjarvis.annotation.SourceSynced;
import com.github.regyl.unfriendlyjarvis.configuration.yandexmusic.YandexMusicConfigurationProperties;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.lickedtracks.LikedTracksResponseDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.lickedtracks.TrackShort;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.TrackInfo;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.TrackResponse;
import com.github.regyl.unfriendlyjarvis.entity.TrackEntity;
import com.github.regyl.unfriendlyjarvis.entity.enums.Source;
import com.github.regyl.unfriendlyjarvis.enumeration.UserSecretKey;
import com.github.regyl.unfriendlyjarvis.exception.JarvisException;
import com.github.regyl.unfriendlyjarvis.feign.YandexMusicFeignClient;
import com.github.regyl.unfriendlyjarvis.model.TrackModel;
import com.github.regyl.unfriendlyjarvis.repository.TrackEntityRepository;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.yandexmusic.YandexMusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class YandexMusicServiceImpl implements YandexMusicService {

    private final SecurityContextService securityContextService;
    private final YandexMusicFeignClient yandexMusicFeignClient;
    private final Function<TrackInfo, TrackModel> trackInfoMapper;
    private final Function<TrackModel, TrackEntity> trackModelMapper;
    private final TrackEntityRepository repository;
    private final YandexMusicConfigurationProperties configProps;

    @Override
    public Collection<TrackEntity> findAll() {
        Long accountId = securityContextService.getUserId();
        return repository.findAllByAccountId(accountId);
    }

    @Override
    @SourceSynced(source = Source.YANDEX_MUSIC)
    @Transactional
    public void uploadTracks() {
        Long yandexMusicAccountId = securityContextService.getAuthorizedUserSecret(UserSecretKey.YANDEX_MUSIC_USER_ID).map(Long::parseLong)
                .orElseThrow(() -> new JarvisException("Yandex music account id is not specified in profile"));

        LikedTracksResponseDto likedTracks = yandexMusicFeignClient.getLikedTracks(yandexMusicAccountId);
        Collection<TrackModel> trackModels = getTracks(likedTracks.getResult().getLibrary().getTracks());
        Collection<TrackEntity> trackEntities = trackModels.stream().map(trackModelMapper).toList();

        repository.deleteAllByAccountIdAndSource(securityContextService.getUserId(), Source.YANDEX_MUSIC);
        repository.saveAll(trackEntities);
    }

    public Collection<TrackModel> getTracks(Collection<TrackShort> trackShort) {
        List<String> ids = trackShort.stream()
                .map(item -> String.format("%s:%s", item.getId(), item.getAlbumId()))
                .toList();
        Collection<List<String>> collections = ListUtils.partition(ids, configProps.getTrackFetchBatchSize());
        Collection<TrackResponse> responses = collections.stream()
                .map(yandexMusicFeignClient::getTrack)
                .toList();
        return responses.stream()
                .flatMap(response -> response.getResult().stream())
                .map(trackInfoMapper)
                .toList();
    }
}
