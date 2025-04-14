package com.example.gocalowly.domain.token.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {

    AccessTokenService accessTokenService;
    RefreshTokenService refreshTokenService;

    public TokenService(AccessTokenService accessTokenService, RefreshTokenService refreshTokenService){
        this.accessTokenService = accessTokenService;
        this.refreshTokenService = refreshTokenService;
    }

    public void setTokens(UUID userId, HttpServletResponse response) {
        String accessToken = accessTokenService.generateAccessToken(userId);

        UUID refreshToken = UUID.randomUUID();
        refreshTokenService.insertRefreshToken(refreshToken, userId);

        response.setHeader("Authorization", "Bearer " + accessToken);
        refreshTokenService.addRefreshTokenToCookie(response, refreshToken);
    }

}
