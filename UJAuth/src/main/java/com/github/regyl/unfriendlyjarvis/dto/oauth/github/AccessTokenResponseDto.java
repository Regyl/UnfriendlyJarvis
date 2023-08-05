package com.github.regyl.unfriendlyjarvis.dto.oauth.github;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.regyl.unfriendlyjarvis.dto.deserializer.ScopeCollectionDeserializer;
import com.github.regyl.unfriendlyjarvis.model.enums.Scope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * DTO with user's access token and allowed scopes.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessTokenResponseDto {
    
    /**
     * Usually used as <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Authorization">Authorization</a> header.
     */
    private String accessToken;

    private String tokenType;

    @JsonDeserialize(using = ScopeCollectionDeserializer.class)
    private Set<Scope> scope;
}
