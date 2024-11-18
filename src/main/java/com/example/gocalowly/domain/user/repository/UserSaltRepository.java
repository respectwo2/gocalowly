package com.example.gocalowly.domain.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gocalowly.domain.user.entity.UserSaltEntity;

public interface UserSaltRepository extends JpaRepository<UserSaltEntity, UUID> {
}
