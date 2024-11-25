package com.example.gocalowly.domain.chat.repository;

import com.example.gocalowly.domain.chat.entity.ChatEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity, Integer> {

    List<ChatEntity> findByGroupNo(int groupNo);

}
