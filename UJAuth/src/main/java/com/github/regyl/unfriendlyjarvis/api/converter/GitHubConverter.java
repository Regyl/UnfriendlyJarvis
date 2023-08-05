package com.github.regyl.unfriendlyjarvis.api.converter;

import com.github.regyl.unfriendlyjarvis.config.oauth.OAuthConfigProperties;
import com.github.regyl.unfriendlyjarvis.dto.RegistrationDto;
import com.github.regyl.unfriendlyjarvis.dto.oauth.OAuthInitializationDto;
import com.github.regyl.unfriendlyjarvis.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.unfriendlyjarvis.dto.oauth.github.UserInfoDto;
import com.github.regyl.unfriendlyjarvis.model.enums.OAuthProviderType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Converter for GitHub request & response DTOs.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class GitHubConverter {

    protected static final OAuthProviderType O_AUTH_PROVIDER_TYPE = OAuthProviderType.GitHub;

    @Autowired
    protected OAuthConfigProperties oAuthConfigProperties;
    
    /**
     * Convert OAuth authorization initialization DTO to access token request DTO.
     *
     * @param initializationDto dto with information to initialize OAuth 2.0 authorization
     * @return                  DTO to request GitHub access token
     */
    @Mappings({
            @Mapping(target = "clientId", expression = """
                    java(oAuthConfigProperties.getProviders()
                        .get(O_AUTH_PROVIDER_TYPE)
                        .getClientId()
                    )
                    """),
            @Mapping(target = "clientSecret", expression = """
                    java(oAuthConfigProperties.getProviders()
                        .get(O_AUTH_PROVIDER_TYPE)
                        .getClientSecret()
                    )
                    """),
            @Mapping(target = "redirectUri", expression = """
                    java(oAuthConfigProperties.getProviders()
                        .get(O_AUTH_PROVIDER_TYPE)
                        .getRedirectUri()
                    )
                    """),
    })
    public abstract AccessTokenRequestDto convert(OAuthInitializationDto initializationDto);
    
    /**
     * Convert user info to internal application DTO.
     *
     * @param userInfoDto   dto with GitHub user's information
     * @return              DTO used to transfer information about user that should be created
     */
    public abstract RegistrationDto convert(UserInfoDto userInfoDto);
}
