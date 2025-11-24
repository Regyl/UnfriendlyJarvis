package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cover {

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("prefix")
    private String prefix;

}
