package com.example.gocalowly.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user_salt")
public class UserSaltEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;
    private String salt;

    public UserSaltEntity() {
    }

    public UserSaltEntity(UUID userId, String salt) {
        super();
        this.userId = userId;
        this.salt = salt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getSalt() {
        return salt;
    }
}
