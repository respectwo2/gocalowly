package com.example.gocalowly.domain.chat.dto.request;

// 채팅을 작성했을 때 사용되는 RequestDto
public class ChatSubmitRequestDto {
	private int groupNo; // 그룹 ID
	private String userNickName; // 유저 No
	private String content; // 채팅 내용
	
	public ChatSubmitRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ChatSubmitRequestDto(int groupNo, String userNickName, String content) {
		super();
		this.groupNo = groupNo;
		this.userNickName = userNickName;
		this.content = content;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public String getuserNickName() {
		return userNickName;
	}

	public String getContent() {
		return content;
	}
	
}
