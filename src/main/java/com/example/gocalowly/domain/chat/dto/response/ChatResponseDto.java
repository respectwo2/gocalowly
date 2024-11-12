package com.example.gocalowly.domain.chat.dto.response;

import java.util.Date;
import java.util.List;

// 채팅 내역을 전달하는 ResponseDto
public class ChatResponseDto {
	private List<Chat> chats; // 채팅 리스트
	
	public static class Chat { // 채팅 클래스를 내부에서 선언
		private String userName; // 채팅 작성자
		private String content; // 채팅 내용
		private Date chatDate; // 채팅 등록 시간
	}
}
