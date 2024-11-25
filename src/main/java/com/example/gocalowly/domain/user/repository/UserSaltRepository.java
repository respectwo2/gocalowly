package com.example.gocalowly.domain.user.repository;

import com.example.gocalowly.domain.user.entity.UserSaltEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSaltRepository extends JpaRepository<UserSaltEntity, UUID> {
}
