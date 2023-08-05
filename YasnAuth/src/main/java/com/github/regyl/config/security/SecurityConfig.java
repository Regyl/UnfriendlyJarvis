package com.github.regyl.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Security configuration.
 */
@Configuration
public class SecurityConfig {

    private static final int B_CRYPT_STRENGTH = 4;

    /**
     * Password encoder.
     *
     * @return password encoder.
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y, B_CRYPT_STRENGTH);
    }

    /**
     * CORS configuration.
     *
     * @return CORS configuration.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    /**
     * Security filter chain.
     *
     * @param http http security.
     * @return security filter chain.
     * @throws Exception exception.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();*/
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests().anyRequest()
                .permitAll();
        return http.build();
    }
}
