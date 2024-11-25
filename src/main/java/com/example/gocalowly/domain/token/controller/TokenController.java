package com.example.gocalowly.domain.token.controller;

import com.example.gocalowly.domain.token.service.AccessTokenService;
import com.example.gocalowly.domain.token.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import org.springframework.stereotype.Controller;

@Controller
public class TokenController {
    AccessTokenService accessTokenService;
    RefreshTokenService refreshTokenService;

    public TokenController(AccessTokenService accessTokenService, RefreshTokenService refreshTokenService) {
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
