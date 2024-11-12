package com.example.gocalowly.domain.chat.dto.response;

import java.util.Date;
import java.util.List;

public class ChatResponseDto {
	private List<Chat> chats;
	
	public static class Chat {
		private String userName;
		private String content;
		private Date chatDate;
	}
}
