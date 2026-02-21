package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DerivedColors {

    @JsonProperty("average")
    private String average;

    @JsonProperty("waveText")
    private String waveText;

    @JsonProperty("miniPlayer")
    private String miniPlayer;

    @JsonProperty("accent")
    private String accent;
}
