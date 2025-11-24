package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LyricsInfo {

    @JsonProperty("hasAvailableSyncLyrics")
    private boolean hasAvailableSyncLyrics;

    @JsonProperty("hasAvailableTextLyrics")
    private boolean hasAvailableTextLyrics;

}
