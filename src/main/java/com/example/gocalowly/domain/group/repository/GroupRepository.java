package com.example.gocalowly.domain.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gocalowly.domain.group.entity.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
}
