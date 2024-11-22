package com.example.gocalowly.domain.token.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
@Transactional
public class RefreshTokenService {
    public void validateRefreshToken(UUID refreshToken, UUID userId) {
    	
    }

	public void updateRefreshToken(UUID randomUUID, UUID userId) {
		
	}
	
    public void addRefreshTokenToCookie(HttpServletResponse response, UUID newRefreshToken) {
        // HttpOnly Cookie로 refresh token 설정
        Cookie cookie = new Cookie("refreshToken", newRefreshToken.toString());
        cookie.setHttpOnly(true);  // HttpOnly 설정
        cookie.setSecure(true);     // HTTPS 프로토콜을 사용할 때는 Secure 설정
        cookie.setPath("/");       // 경로 설정 (예: 모든 URL에서 유효하도록 "/")
        cookie.setMaxAge(60 * 60 * 24 * 30);  // 만료 시간 (예: 30일)

        // 응답에 추가
        response.addCookie(cookie);
    }
}
