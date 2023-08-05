package com.github.regyl.model.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public enum Scope {

    REPO,
    GIST,
    USER;

    public static Optional<Scope> fromName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Optional.empty();
        }

        return Arrays.stream(Scope.values())
                .filter(scope -> name.equalsIgnoreCase(scope.name()))
                .findFirst();
    }
}
