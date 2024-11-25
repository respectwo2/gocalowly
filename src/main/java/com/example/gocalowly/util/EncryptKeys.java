package com.example.gocalowly.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptKeys {
    private static KeyPair JWE_KEY_PAIR;
    private static SecretKey REFRESH_TOKEN_KEY;

    static {
        try {
            KeyPairGenerator RSAGenerator = KeyPairGenerator.getInstance("RSA");
            RSAGenerator.initialize(2048);
            JWE_KEY_PAIR = RSAGenerator.generateKeyPair();

            KeyGenerator AESGenerator = KeyGenerator.getInstance("AES");
            AESGenerator.init(128);
            REFRESH_TOKEN_KEY = AESGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static RSAPublicKey getPublicKey() {
        return (RSAPublicKey) JWE_KEY_PAIR.getPublic();
    }

    public static RSAPrivateKey getPrivateKey() {
        return (RSAPrivateKey) JWE_KEY_PAIR.getPrivate();
    }

    public static SecretKey getRefreshTokenKey() {
        return REFRESH_TOKEN_KEY;
    }
}
