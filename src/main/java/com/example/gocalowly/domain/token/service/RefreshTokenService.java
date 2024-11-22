package com.example.gocalowly.domain.token.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.UUID;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.token.entity.RefreshTokenEntity;
import com.example.gocalowly.domain.token.exception.TokenException;
import com.example.gocalowly.domain.token.repository.RefreshTokenRepository;
import com.example.gocalowly.util.EncryptKeys;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class RefreshTokenService {
	RefreshTokenRepository refreshTokenRepository;
	
	public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
		this.refreshTokenRepository = refreshTokenRepository;
	}

	@Transactional
	public void insertRefreshToken(UUID refreshToken, UUID userId) {	
		try {
			refreshTokenRepository.deleteByUserId(userId);
			RefreshTokenEntity refreshTokenEntity = new RefreshTokenEntity(userId);

			refreshTokenEntity.setEncryptedRefreshToken(encryptRefreshToken(refreshToken));
			refreshTokenEntity.setCreateTime(LocalDateTime.now());
			refreshTokenEntity.setExpireTime(LocalDateTime.now().plusDays(30));

			refreshTokenRepository.save(refreshTokenEntity);
		} catch (Exception e) {
			throw new TokenException("refresh token 삽입 과정에서 문제!!");
		}		
	}
	
	@Transactional
    public boolean validateAndUpdateRefreshToken(UUID newRefreshToken, UUID refreshToken, UUID userId) {
    	RefreshTokenEntity dataRefreshTokenEntity = refreshTokenRepository.findByUserId(userId)
    			.orElseThrow(() -> new NoSuchElementException());

    	try {
			if (!validateRefreshToken(dataRefreshTokenEntity, refreshToken)) {
				refreshTokenRepository.deleteByUserId(userId);
				return false;
			}
			
	    	dataRefreshTokenEntity.setEncryptedRefreshToken(encryptRefreshToken(newRefreshToken));
	    	dataRefreshTokenEntity.setCreateTime(LocalDateTime.now());
	    	dataRefreshTokenEntity.setExpireTime(LocalDateTime.now().plusDays(30));
	    	refreshTokenRepository.save(dataRefreshTokenEntity);
	    		
	    	return true;
	    	
		}catch(Exception e) {
			throw new TokenException("refresh token 암호화/복호화 과정에서 문제!!");
    	}	
    }

    private boolean validateRefreshToken(RefreshTokenEntity dataRefreshTokenEntity, UUID refreshToken) throws Exception{
		return decryptRefreshToken(dataRefreshTokenEntity.getEncryptedRefreshToken()).equals(refreshToken.toString())
				&& dataRefreshTokenEntity.getExpireTime().isAfter(LocalDateTime.now());
	}
    
    private String decryptRefreshToken(String encryptedRefreshToken) throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, EncryptKeys.getRefreshTokenKey());
		
		return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedRefreshToken)));
    }
    
    private String encryptRefreshToken(UUID refreshToken) throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, EncryptKeys.getRefreshTokenKey());
		
		return Base64.getEncoder().encodeToString(cipher.doFinal(refreshToken.toString().getBytes()));
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
