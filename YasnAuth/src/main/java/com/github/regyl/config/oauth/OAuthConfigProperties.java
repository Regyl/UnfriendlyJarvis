package com.github.regyl.config.oauth;

import com.github.regyl.model.enums.OAuthProviderType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * OAuth 2.0 configuration properties.
 */
@Slf4j(topic = "OAuthConfigProperties")
@Data
@Configuration
@ConfigurationProperties(prefix = "application.oauth")
public class OAuthConfigProperties implements InitializingBean {

    private Map<OAuthProviderType, OAuthClientProperties> providers;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (MapUtils.isEmpty(providers)) {
            log.warn("OAuth 2.0 providers not set");
        }
    }

    /**
     * OAuth 2.0 client properties.
     */
    @Data
    public static class OAuthClientProperties {

        private String clientId;

        private String clientSecret;

        private String redirectUri;
    }
}
