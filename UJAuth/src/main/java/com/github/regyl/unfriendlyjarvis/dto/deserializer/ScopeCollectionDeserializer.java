package com.github.regyl.unfriendlyjarvis.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.regyl.unfriendlyjarvis.model.enums.Scope;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Deserializer for {@link Scope} collection.
 */
public class ScopeCollectionDeserializer extends JsonDeserializer<Collection<Scope>> {

    private static final String DELIMITER = ",";

    @Override
    public Collection<Scope> deserialize(JsonParser p,
                                         DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        Collection<Scope> scopes = null;
        if (StringUtils.isNoneEmpty(value)) {
            String[] scopesAsString = value.split(DELIMITER);
            scopes = new HashSet<>(scopesAsString.length + 1, 1);

            for (String stringScope : scopesAsString) {
                Scope.fromName(stringScope).ifPresent(scopes::add);
            }
        }

        return scopes;
    }
}
