package com.example.gocalowly.domain.chat.dto.request;

// 채팅을 작성했을 때 사용되는 RequestDto
public class ChatSubmitRequestDto {
	private int groupId; // 그룹 ID
	private int userNo; // 유저 No
	private String content; // 채팅 내용
}
