package com.example.gocalowly.domain.chat.dto.request;

import jakarta.validation.constraints.NotBlank;

// 채팅을 작성했을 때 사용되는 RequestDto
public class ChatSubmitRequestDto {
	@NotBlank(message = "내용을 입력해주세요")
	private String content; // 채팅 내용
	
	public ChatSubmitRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatSubmitRequestDto(String content) {
		super();
		this.content = content;
	}


	public String getContent() {
		return content;
	}
	
}
