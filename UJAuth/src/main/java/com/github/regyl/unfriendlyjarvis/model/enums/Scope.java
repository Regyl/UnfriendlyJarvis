package com.github.regyl.unfriendlyjarvis.model.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * Supported OAuth 2.0 scopes.
 */
public enum Scope {

    REPO,
    GIST,
    USER;
    
    /**
     * Returns the scope from the given name.
     *
     * @param name  the scope name
     * @return      the scope
     */
    public static Optional<Scope> fromName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Optional.empty();
        }

        return Arrays.stream(Scope.values())
                .filter(scope -> name.equalsIgnoreCase(scope.name()))
                .findFirst();
    }
}
