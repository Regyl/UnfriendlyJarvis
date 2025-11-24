package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String type;

    @JsonProperty("metaType")
    private String metaType;

    @JsonProperty("year")
    private int year;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("coverUri")
    private String coverUri;

    @JsonProperty("ogImage")
    private String ogImage;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("trackCount")
    private int trackCount;

    @JsonProperty("likesCount")
    private long likesCount;

    @JsonProperty("recent")
    private boolean recent;

    @JsonProperty("veryImportant")
    private boolean veryImportant;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("labels")
    private List<Label> labels;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("availableForPremiumUsers")
    private boolean availableForPremiumUsers;

    @JsonProperty("availableForOptions")
    private List<String> availableForOptions;

    @JsonProperty("availableForMobile")
    private boolean availableForMobile;

    @JsonProperty("availablePartially")
    private boolean availablePartially;

    @JsonProperty("bests")
    private List<String> bests;

    @JsonProperty("disclaimers")
    private List<String> disclaimers;

    @JsonProperty("listeningFinished")
    private boolean listeningFinished;

    @JsonProperty("trackPosition")
    private TrackPosition trackPosition;

}
