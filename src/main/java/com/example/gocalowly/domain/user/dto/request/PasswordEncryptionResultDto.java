package com.example.gocalowly.domain.user.dto.request;

public class PasswordEncryptionResultDto {
    private final String hashedPassword;
    private final String salt;

    public PasswordEncryptionResultDto(String hashedPassword, String salt) {
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }
}

