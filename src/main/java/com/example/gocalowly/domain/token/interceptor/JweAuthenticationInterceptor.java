package com.example.gocalowly.domain.token.interceptor;

import com.example.gocalowly.domain.token.exception.TokenException;
import com.example.gocalowly.domain.token.service.AccessTokenService;
import com.example.gocalowly.domain.token.service.RefreshTokenService;
import com.nimbusds.jwt.JWTClaimsSet;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JweAuthenticationInterceptor implements HandlerInterceptor {
    private final RefreshTokenService refreshTokenService; // Access/Refresh Token 관리 서비스
    private final AccessTokenService accessTokenService;

    public JweAuthenticationInterceptor(RefreshTokenService refreshTokenService, AccessTokenService accessTokenService) {
    	this.refreshTokenService = refreshTokenService;
    	this.accessTokenService = accessTokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. Access Token 추출 및 검증
        String accessToken = resolveAccessToken(request);
        System.out.println(accessToken);
        if (accessToken != null) {
            try {
                JWTClaimsSet claims = accessTokenService.decryptJWE(accessToken);

                // Access Token 유효성 확인
                if (accessTokenService.isValidClaims(claims)) {
                    return true; // 유효한 Access Token이므로 요청 진행
                }
            } catch (Exception e) {
                response.getWriter().write(e.getMessage());
            }
        }

        // 2. Access Token 만료 시 Refresh Token 검증
        UUID refreshToken = resolveRefreshToken(request);
        if (refreshToken != null) {
            try {
            	JWTClaimsSet claims = accessTokenService.decryptJWE(accessToken);
                UUID userId = UUID.fromString((String)claims.getClaim("userId"));

                UUID newRefreshToken = UUID.randomUUID();
                if (!refreshTokenService.validateAndUpdateRefreshToken(newRefreshToken, refreshToken, userId)) {
                	throw new TokenException("please login again!");
                };

                // 새로운 Access Token 생성
                String newAccessToken = accessTokenService.generateAccessToken(userId);
                
                // 새로운 Access Token을 응답 헤더에 설정
                response.setHeader("Authorization", "Bearer " + newAccessToken);
                refreshTokenService.addRefreshTokenToCookie(response, refreshToken);

                return true; // Refresh Token 검증 성공
                
            }catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(e.getMessage());
                return false; // Refresh Token 검증 실패
            }
        }

        // Access Token 및 Refresh Token 모두 실패한 경우
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized");
        return false;
    }

    private String resolveAccessToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 제거
        }
        return null;
    }

    private UUID resolveRefreshToken(HttpServletRequest request) {
        // Refresh Token은 HttpOnly Cookie로 전달되므로 쿠키에서 추출
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("refreshToken".equals(cookie.getName())) {
                    return UUID.fromString(cookie.getValue());
                }
            }
        }
        return null;
    }
}