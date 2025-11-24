package com.github.regyl.unfriendlyjarvis.service.impl.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.regyl.unfriendlyjarvis.entity.enums.OAuthProviderType;

import java.io.IOException;

/**
 * Deserializer for {@link OAuthProviderType}.
 */
public class OAuthProviderTypeDeserializer extends JsonDeserializer<OAuthProviderType> {

    @Override
    public OAuthProviderType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = p.getValueAsString();
        return OAuthProviderType.fromName(value);
    }
}
