package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.feign.track;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("realId")
    private String realId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("major")
    private Major major;

    @JsonProperty("available")
    private boolean available;

    @JsonProperty("availableForPremiumUsers")
    private boolean availableForPremiumUsers;

    @JsonProperty("availableFullWithoutPermission")
    private boolean availableFullWithoutPermission;

    @JsonProperty("availableForOptions")
    private List<String> availableForOptions;

    @JsonProperty("disclaimers")
    private List<String> disclaimers;

    @JsonProperty("storageDir")
    private String storageDir;

    @JsonProperty("durationMs")
    private long durationMs;

    @JsonProperty("fileSize")
    private long fileSize;

    @JsonProperty("previewDurationMs")
    private long previewDurationMs;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("albums")
    private List<Album> albums;

    @JsonProperty("coverUri")
    private String coverUri;

    @JsonProperty("derivedColors")
    private DerivedColors derivedColors;

    @JsonProperty("ogImage")
    private String ogImage;

    @JsonProperty("lyricsAvailable")
    private boolean lyricsAvailable;

    @JsonProperty("type")
    private String type;

    @JsonProperty("rememberPosition")
    private boolean rememberPosition;

    @JsonProperty("trackSharingFlag")
    private String trackSharingFlag;

    @JsonProperty("lyricsInfo")
    private LyricsInfo lyricsInfo;

    @JsonProperty("trackSource")
    private String trackSource;

    @JsonProperty("specialAudioResources")
    private List<String> specialAudioResources;
}
