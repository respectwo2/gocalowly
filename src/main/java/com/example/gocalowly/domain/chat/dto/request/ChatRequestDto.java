package com.example.gocalowly.domain.chat.dto.request;

// 채팅 내역을 불러오는 RequestDto
public class ChatRequestDto {
	private int groupNo; // 그룹ID를 전달
	
	public ChatRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatRequestDto(int groupNo) {
		super();
		this.groupNo = groupNo;
	}

	public int getGroupNo() {
		return groupNo;
	}
	
}
