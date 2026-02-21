package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.lickedtracks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @JsonProperty("uid")
    private long uid;

    @JsonProperty("revision")
    private long revision;

    @JsonProperty("playlistUuid")
    private String playlistUuid;

    @JsonProperty("tracks")
    private List<TrackShort> tracks;

}
