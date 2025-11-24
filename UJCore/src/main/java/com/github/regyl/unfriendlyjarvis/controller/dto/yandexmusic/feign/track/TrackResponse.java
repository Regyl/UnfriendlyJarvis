package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.InvocationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackResponse {

    @JsonProperty("invocationInfo")
    private InvocationInfo invocationInfo;

    @JsonProperty("result")
    private List<TrackInfo> result;

}
