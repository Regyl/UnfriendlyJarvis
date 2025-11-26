package com.github.regyl.unfriendlyjarvis.service.impl.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.regyl.unfriendlyjarvis.enumeration.Scope;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Deserializer for {@link Scope} collection.
 */
public class ScopeCollectionDeserializer extends JsonDeserializer<Collection<Scope>> {

    private static final String DELIMITER = ",";

    @Override
    public Collection<Scope> deserialize(JsonParser p,
                                         DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (StringUtils.isEmpty(value)) {
            return Collections.emptySet();
        }

        return Stream.of(value.split(DELIMITER))
                .map(Scope::fromName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
