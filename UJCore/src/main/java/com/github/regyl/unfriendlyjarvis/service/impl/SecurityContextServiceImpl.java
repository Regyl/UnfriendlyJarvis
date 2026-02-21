package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.enumeration.UserSecretKey;
import com.github.regyl.unfriendlyjarvis.exception.JwtTokenIsBrokenException;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.service.usersecretdata.UserSecretDataService;
import com.github.regyl.unfriendlyjarvis.util.JwtTokenReader;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * Implementation of SecurityContextService that extracts account information from JWT token.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityContextServiceImpl implements SecurityContextService {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final UserSecretDataService userSecretDataService;

    private final JwtTokenReader jwtTokenReader;

    @Override
    public Long getUserId() {
        String jwtToken = getJwtTokenFromRequest();
        return jwtTokenReader.getUserIdFromToken(jwtToken);
    }

    @Override
    public Optional<String> getAuthorizedUserSecret(UserSecretKey key) {
        String jwtToken = getJwtTokenFromRequest();
        Long userId = jwtTokenReader.getUserIdFromToken(jwtToken);
        return userSecretDataService.getSecretData(userId, key.getKey());
    }

    /**
     * Extract JWT token from current HTTP request.
     *
     * @return JWT token or null
     */
    private String getJwtTokenFromRequest() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }

        HttpServletRequest request = attributes.getRequest();
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX.length());
        }
        throw new JwtTokenIsBrokenException();
    }
}
