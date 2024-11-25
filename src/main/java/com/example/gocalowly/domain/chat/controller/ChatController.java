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

@RestController
@RequestMapping("/api/chat")

public class ChatController {

    private static final int TEST_GROUPNO = 1;
    private static final UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final String TEST_NICKNAME = "윤상민천재";

    ChatService chatService;

    public ChatController(ChatService chatservice) {
        this.chatService = chatservice;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> createChat(@Valid @RequestBody ChatSubmitRequestDto chatSubmitRequestDto) {
        chatService.addChat(chatSubmitRequestDto, TEST_NICKNAME, TEST_GROUPNO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/logs")
    public ResponseEntity<List<ChatResponseDto>> findChatLog() {
        List<ChatResponseDto> response = chatService.findChat(TEST_GROUPNO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
