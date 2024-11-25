package com.example.gocalowly.domain.token.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gocalowly.domain.token.entity.RefreshTokenEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Integer>{
	Optional<RefreshTokenEntity> findByUserId(UUID userId);
	
	void deleteByUserId(UUID userId);
}
