package com.github.regyl.unfriendlyjarvis.service.impl.converter;

import com.github.regyl.unfriendlyjarvis.configuration.oauth.OAuthConfigProperties;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.OAuthInitializationDto;
import com.github.regyl.unfriendlyjarvis.controller.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.unfriendlyjarvis.enumeration.OAuthProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * Mapper for converting OAuth initialization DTO to access token request DTO.
 */
@Component
@RequiredArgsConstructor
public class OAuthInitializationToAccessTokenRequestMapper implements Function<OAuthInitializationDto, AccessTokenRequestDto> {

    private static final OAuthProviderType O_AUTH_PROVIDER_TYPE = OAuthProviderType.GitHub;

    private final OAuthConfigProperties oAuthConfigProperties;

    /**
     * Convert OAuth authorization initialization DTO to access token request DTO.
     * Implements Function interface.
     *
     * @param initializationDto dto with information to initialize OAuth 2.0 authorization
     * @return                  DTO to request GitHub access token
     */
    @Override
    public AccessTokenRequestDto apply(OAuthInitializationDto initializationDto) {
        if (initializationDto == null) {
            return null;
        }

        OAuthConfigProperties.OAuthClientProperties clientProperties = 
                oAuthConfigProperties.getProviders().get(O_AUTH_PROVIDER_TYPE);

        if (clientProperties == null) {
            throw new IllegalStateException(
                    "OAuth client properties not configured for provider: " + O_AUTH_PROVIDER_TYPE);
        }

        AccessTokenRequestDto requestDto = new AccessTokenRequestDto();
        requestDto.setCode(initializationDto.getCode());
        requestDto.setClientId(clientProperties.getClientId());
        requestDto.setClientSecret(clientProperties.getClientSecret());
        requestDto.setRedirectUri(clientProperties.getRedirectUri());

        return requestDto;
    }
}



