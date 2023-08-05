package com.github.regyl.dto.oauth.github;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.regyl.ScopeCollectionDeserializer;
import com.github.regyl.model.enums.Scope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessTokenResponseDto {

    private String accessToken;

    private String tokenType;

    @JsonDeserialize(using = ScopeCollectionDeserializer.class)
    private Set<Scope> scope;
}
