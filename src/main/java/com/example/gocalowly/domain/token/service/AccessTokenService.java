package com.example.gocalowly.domain.token.service;

import com.example.gocalowly.domain.token.exception.TokenException;
import com.example.gocalowly.util.EncryptKeys;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jwt.JWTClaimsSet;
import java.security.PrivateKey;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService {

    public String generateAccessToken(UUID userId) {
        // JWT Claims
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .claim("userId", userId)
                .expirationTime(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // 5분 유효
                .build();

        // JWE Header
        JWEHeader header = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM)
                .contentType("JWT")
                .build();

        // JWE Object
        JWEObject jweObject = new JWEObject(header, new Payload(claims.toJSONObject()));

        // Encrypt JWE with RSA Public Key
        try {
            jweObject.encrypt(new RSAEncrypter(EncryptKeys.getPublicKey()));
        } catch (JOSEException e) {
            throw new TokenException("access token 암호화 과정에서 문제!");
        }

        return jweObject.serialize();
    }

    // JWE 검증 메서드
    public JWTClaimsSet decryptJWE(String jweToken) throws ParseException, JOSEException {
        // 1. JWE 토큰 파싱
        JWEObject jweObject = JWEObject.parse(jweToken);

        // 2. RSA 개인 키를 사용해 복호화
        PrivateKey privateKey = EncryptKeys.getPrivateKey();
        jweObject.decrypt(new RSADecrypter(privateKey));

        // 3. Payload에서 JWT Claims 추출
        String payload = jweObject.getPayload().toString();

        // 4. Payload를 JWTClaimsSet으로 변환
        return JWTClaimsSet.parse(payload);
    }

    // Payload 검증 메서드
    public boolean isValidClaims(JWTClaimsSet claims) {
        try {
            // 1. 만료 시간 (exp) 검증
            if (claims.getExpirationTime() == null || claims.getExpirationTime().before(new Date())) {
                return false;
            }

            // 2. 필수 Claims 검증 (예: userId 존재 여부)
            return claims.getClaim("userId") != null;

            // 추가적인 검증 로직 필요시 여기에 추가
        } catch (Exception e) {
            return false;
        }
    }
}
