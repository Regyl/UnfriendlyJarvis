package com.github.regyl.unfriendlyjarvis.service.impl.yandexmusic;

import com.github.regyl.unfriendlyjarvis.annotation.DefaultUnitTest;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.Artist;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track.TrackInfo;
import com.github.regyl.unfriendlyjarvis.model.TrackModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUnitTest
class TrackInfoToTrackModelMapperServiceImplTest {

    @InjectMocks
    private TrackInfoToTrackModelMapperServiceImpl service;

    @Test
    void testSingleArtist() {
        TrackInfo info = new TrackInfo();
        Artist artist = new Artist();
        artist.setName("Flo Rida");
        info.setArtists(List.of(artist));

        TrackModel model = service.apply(info);

        assertThat(model).isNotNull();
        assertThat(model.getArtistName()).isEqualTo("Flo Rida");
    }

    @Test
    void testMultipleArtists() {
        TrackInfo info = new TrackInfo();
        Artist artist = new Artist();
        artist.setName("Flo Rida");
        Artist artist2 = new Artist();
        artist2.setName("DJ Antonie");
        info.setArtists(List.of(artist, artist2));

        TrackModel model = service.apply(info);

        assertThat(model).isNotNull();
        assertThat(model.getArtistName()).isEqualTo("Flo Rida, DJ Antonie");
    }
}
