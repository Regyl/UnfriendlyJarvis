package com.github.regyl.unfriendlyjarvis.dto.oauth.github;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO to request GitHub access token.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessTokenRequestDto {

    private String clientId;

    private String clientSecret;

    private String code;

    private String redirectUri;
}
