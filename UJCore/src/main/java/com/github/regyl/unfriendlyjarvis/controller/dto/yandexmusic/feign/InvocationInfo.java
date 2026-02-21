package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvocationInfo {

    @JsonProperty("req-id")
    private String reqId;

    @JsonProperty("hostname")
    private String hostname;

    @JsonProperty("exec-duration-millis")
    private long execDurationMillis;
}
