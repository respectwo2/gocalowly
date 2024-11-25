package com.example.gocalowly.domain.chat.mapper;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.entity.ChatEntity;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper {

    public ChatEntity dtoToEntity(ChatSubmitRequestDto request, String userNickname, int groupNo) {

        return new ChatEntity(userNickname, request.getContent(), groupNo);

    }

}
