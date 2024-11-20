package com.example.gocalowly.domain.chat.dto.response;

import java.time.LocalDateTime;

// 채팅 내역을 전달하는 ResponseDto
public class ChatResponseDto {
    private String userNickName; // 채팅 작성자
    private String content;      // 채팅 내용
    private LocalDateTime chatDate; // 채팅 등록 시간

    public ChatResponseDto(String userNickName, String content, LocalDateTime chatDate) {
        this.userNickName = userNickName;
        this.content = content;
        this.chatDate = chatDate;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getChatDate() {
        return chatDate;
    }

	@Override
	public String toString() {
		return "ChatResponseDto [userNickName=" + userNickName + ", content=" + content + ", chatDate=" + chatDate
				+ "]";
	}
    
    

    
    
}
