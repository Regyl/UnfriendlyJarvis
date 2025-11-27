package com.github.regyl.unfriendlyjarvis.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for JWT token response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {

    /**
     * Access token (short-lived).
     */
    private String accessToken;

    /**
     * Refresh token (long-lived).
     */
    private String refreshToken;

    /**
     * Token type (usually "Bearer").
     */
    private String tokenType = "Bearer";
}



