package com.example.gocalowly.domain.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gocalowly.domain.user.entity.UserGoalEntity;

public interface UserGoalRepository extends JpaRepository<UserGoalEntity, Integer>{
}
