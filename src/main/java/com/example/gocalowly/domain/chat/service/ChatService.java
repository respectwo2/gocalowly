package com.example.gocalowly.domain.chat.service;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.dto.response.ChatResponseDto;
import com.example.gocalowly.domain.chat.entity.ChatEntity;
import com.example.gocalowly.domain.chat.mapper.ChatMapper;
import com.example.gocalowly.domain.chat.repository.ChatRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    ChatRepository chatRepository;
    ChatMapper chatMapper;

    public ChatService(ChatRepository chatRepository, ChatMapper chatMapper) {
        this.chatRepository = chatRepository;
        this.chatMapper = chatMapper;
    }

    //비어있는 채팅도 정상적인 응답으로 간주해 예외 처리 하지않음
    public List<ChatResponseDto> findChat(int groupNo) {
        List<ChatEntity> chatEntities = chatRepository.findByGroupNo(groupNo);

        return chatEntities.stream()
                .map(chat -> new ChatResponseDto(
                        chat.getUserNickname(),
                        chat.getContent(),
                        chat.getchatDate()
                ))
                .collect(Collectors.toList());
    }

    public void addChat(ChatSubmitRequestDto chatSubmitRequestDto, String userNickname, int groupNo) {
        chatRepository.save(chatMapper.dtoToEntity(chatSubmitRequestDto, userNickname, groupNo));
    }
}
