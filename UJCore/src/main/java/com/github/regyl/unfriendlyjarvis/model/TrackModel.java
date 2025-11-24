package com.github.regyl.unfriendlyjarvis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @see {@link com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic.TrackDto}.
 * Should be equal.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class TrackModel {

    private String name;

    private String coverUrl;

    private String artistName;
}
