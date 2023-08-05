package com.github.regyl.dto.oauth;

import com.github.regyl.model.enums.OAuthProviderType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO with information to initialize OAuth 2.0 authorization.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuthInitializationDto {

    @NotEmpty
    private String code;
    
    private String state;

    @NotNull
    private OAuthProviderType oAuthProviderType;
}
