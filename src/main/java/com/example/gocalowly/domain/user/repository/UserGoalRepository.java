package com.example.gocalowly.domain.user.repository;

import com.example.gocalowly.domain.user.entity.UserGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGoalRepository extends JpaRepository<UserGoalEntity, Integer> {
}
