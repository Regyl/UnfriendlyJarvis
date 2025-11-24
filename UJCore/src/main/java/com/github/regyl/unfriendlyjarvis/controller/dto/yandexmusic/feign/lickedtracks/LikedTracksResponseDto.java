package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.lickedtracks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.InvocationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikedTracksResponseDto {

    @JsonProperty("invocationInfo")
    private InvocationInfo invocationInfo;

    @JsonProperty("result")
    private Result result;
}
