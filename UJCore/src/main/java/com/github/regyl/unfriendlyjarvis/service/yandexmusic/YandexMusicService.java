package com.github.regyl.unfriendlyjarvis.service.yandexmusic;

import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.TrackDto;
import com.github.regyl.unfriendlyjarvis.entity.TrackEntity;
import com.github.regyl.unfriendlyjarvis.service.CrudService;

public interface YandexMusicService extends CrudService<TrackEntity> {

    void uploadTracks();
}
