package com.github.regyl.api.converter;

import com.github.regyl.config.oauth.OAuthConfigProperties;
import com.github.regyl.dto.RegistrationDto;
import com.github.regyl.dto.oauth.OAuthInitializationDto;
import com.github.regyl.dto.oauth.github.AccessTokenRequestDto;
import com.github.regyl.dto.oauth.github.UserInfoDto;
import com.github.regyl.model.enums.OAuthProviderType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class GitHubConverter {

    protected static final OAuthProviderType O_AUTH_PROVIDER_TYPE = OAuthProviderType.GitHub;

    @Autowired
    protected OAuthConfigProperties oAuthConfigProperties;


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

    public abstract RegistrationDto convert(UserInfoDto userInfoDto);
}
