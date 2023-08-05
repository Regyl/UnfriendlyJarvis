package com.github.regyl.api.oauth;

import com.github.regyl.dto.oauth.OAuthInitializationDto;

public interface OAuthService extends OAuthSupportedProvider {

    boolean exists(OAuthInitializationDto initializationDto);

    void signUp(OAuthInitializationDto initializationDto);
}
