package com.example.gocalowly.domain.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gocalowly.domain.chat.entity.ChatEntity;

public interface ChatRepository extends JpaRepository<ChatEntity, Integer>{

    List<ChatEntity> findByGroupNo(int groupNo);

}
