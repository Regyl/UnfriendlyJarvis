package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.lickedtracks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackShort {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("albumId")
    private Long albumId;

    @JsonProperty("timestamp")
    private String timestamp;
}
