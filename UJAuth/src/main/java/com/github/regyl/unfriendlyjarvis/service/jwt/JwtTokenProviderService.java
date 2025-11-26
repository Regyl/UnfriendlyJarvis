package com.github.regyl.unfriendlyjarvis.service.jwt;

import com.github.regyl.unfriendlyjarvis.entity.User;

import java.util.List;

public interface JwtTokenProviderService {

    String generateAccessToken(User user);

    String generateRefreshToken(User user);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);

    String getTokenTypeFromToken(String token);

    List<String> getAuthoritiesFromToken(String token);

    boolean isRefreshToken(String token);
}
