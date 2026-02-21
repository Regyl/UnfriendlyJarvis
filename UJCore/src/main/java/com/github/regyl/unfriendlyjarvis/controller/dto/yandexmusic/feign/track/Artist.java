package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("various")
    private boolean various;

    @JsonProperty("composer")
    private boolean composer;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("cover")
    private Cover cover;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("disclaimers")
    private List<String> disclaimers;

}
