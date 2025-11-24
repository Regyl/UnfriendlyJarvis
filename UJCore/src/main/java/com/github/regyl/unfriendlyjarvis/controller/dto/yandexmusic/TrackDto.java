package com.github.regyl.unfriendlyjarvis.controller.dto.yandexmusic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto {

    private String name;

    private String coverUrl;

    private String artistName;
}
