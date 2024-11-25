package com.example.gocalowly.domain.token.repository;

import com.example.gocalowly.domain.token.entity.RefreshTokenEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Integer> {
    Optional<RefreshTokenEntity> findByUserId(UUID userId);

    void deleteByUserId(UUID userId);
}
