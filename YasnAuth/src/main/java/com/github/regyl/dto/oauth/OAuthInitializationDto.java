package com.github.regyl.dto.oauth;

import com.github.regyl.model.enums.OAuthProviderType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuthInitializationDto {

    @NotEmpty
    private String code;

    @NotEmpty
    private String state;

    @NotNull
    private OAuthProviderType oAuthProviderType;
}
