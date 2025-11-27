package com.github.regyl.unfriendlyjarvis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class MemeModel {

    private final String bucketPath;

    private final String source;

    private final String fileName;
}
