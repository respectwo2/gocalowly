package com.example.gocalowly.domain.chat.controller;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.dto.response.ChatResponseDto;
import com.example.gocalowly.domain.chat.service.ChatService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api/chat")

public class ChatController {
    ChatService chatService;

    public ChatController(ChatService chatservice) {
        this.chatService = chatservice;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> createChat(@Valid @RequestBody ChatSubmitRequestDto chatSubmitRequestDto,
    		@SessionAttribute String userNickname, @SessionAttribute int groupNo) {
        chatService.addChat(chatSubmitRequestDto, userNickname, groupNo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/logs")
    public ResponseEntity<List<ChatResponseDto>> findChatLog(@SessionAttribute int groupNo) {
        List<ChatResponseDto> response = chatService.findChat(groupNo);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
