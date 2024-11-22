package com.example.gocalowly.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JweKeys {
	private static KeyPair JWE_KEY_PAIR;
	private static String REFRESH_TOKEN_KEY;
	
	static {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			JWE_KEY_PAIR = generator.generateKeyPair();
			REFRESH_TOKEN_KEY = "mySecretKey12345";
		} catch (NoSuchAlgorithmException e) {
		}
	}
	
	public static RSAPublicKey getPublicKey() {
		return (RSAPublicKey) JWE_KEY_PAIR.getPublic();
	}
	
	public static RSAPrivateKey getPrivateKey() {
		return (RSAPrivateKey) JWE_KEY_PAIR.getPrivate();
	}
	
	public static String getRefreshTokenKey() {
		return REFRESH_TOKEN_KEY;
	}
}
