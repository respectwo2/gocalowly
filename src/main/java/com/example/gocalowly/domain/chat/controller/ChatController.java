package com.example.gocalowly.domain.chat.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.dto.response.ChatResponseDto;
import com.example.gocalowly.domain.chat.service.ChatService;

import jakarta.validation.Valid;

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
		try {
		chatService.addChat(chatSubmitRequestDto, TEST_NICKNAME, TEST_GROUPNO);
		//성공적으로 리소스 업데이트 반영
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			//유효하지않은 요청
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
	}

	@GetMapping("/logs")
	public ResponseEntity<List<ChatResponseDto>> findChatLog() {
		try {
			List<ChatResponseDto> response = chatService.findChat(TEST_GROUPNO);
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
