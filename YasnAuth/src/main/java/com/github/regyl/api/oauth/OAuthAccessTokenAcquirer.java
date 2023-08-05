package com.github.regyl.api.oauth;

import com.github.regyl.dto.oauth.OAuthInitializationDto;

public interface OAuthAccessTokenAcquirer extends OAuthSupportedProvider {

    String acquire(OAuthInitializationDto initializationDto);
}
