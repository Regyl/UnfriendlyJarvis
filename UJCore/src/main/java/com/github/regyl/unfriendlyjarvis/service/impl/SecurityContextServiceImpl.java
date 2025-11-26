package com.github.regyl.unfriendlyjarvis.service.impl;

import com.github.regyl.unfriendlyjarvis.entity.Account;
import com.github.regyl.unfriendlyjarvis.exception.JwtTokenIsBrokenException;
import com.github.regyl.unfriendlyjarvis.service.SecurityContextService;
import com.github.regyl.unfriendlyjarvis.util.JwtTokenReader;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Implementation of SecurityContextService that extracts account information from JWT token.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityContextServiceImpl implements SecurityContextService {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private static final Account MOCK;

    static {
        MOCK = new Account();
        MOCK.setId(1L);
        MOCK.setLogin("Regyl");
        MOCK.setYandexMusicUserId(1430257434L);
    }

    private final JwtTokenReader jwtTokenReader;

    @Override
    public Account getAuthorizedAccount() {
        String jwtToken = getJwtTokenFromRequest();
        String userId = jwtTokenReader.getUserIdFromToken(jwtToken);
        return MOCK;
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
