package com.regyl.yetanothersocialnetworkcore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${security.enabled:true}")
    private boolean isSecurityEnabled;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        if (!isSecurityEnabled) {
            http.authorizeHttpRequests((authz) ->
                            authz.anyRequest().permitAll())
                    .httpBasic(withDefaults());
        } else {
            http.authorizeHttpRequests((authz) ->
                            authz.anyRequest().authenticated())
                    .httpBasic(withDefaults());
        }
        return http.build();
    }
}
