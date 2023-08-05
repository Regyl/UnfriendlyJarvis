package com.github.regyl.api.oauth;

import com.github.regyl.model.enums.OAuthProviderType;

public interface OAuthSupportedProvider {

    OAuthProviderType getSupportedProvider();
}
