package com.example.gocalowly.domain.chat.entity;

import java.time.LocalDateTime;

public class ChatEntity {
	private int chatNo;
	private String userNickName;
	private LocalDateTime charDate;
	private String content;
	private int groupNo;
	
	public ChatEntity() {
		// TODO Auto-generated constructor stub
	}
	
	//현재 시간 포맷팅 추가 구현 필요
	public ChatEntity(String userNickName, String content, int groupNo) {
		super();
		this.userNickName = userNickName;
		this.charDate = LocalDateTime.now();
		this.content = content;
		this.groupNo = groupNo;
	}

	public int getChatNo() {
		return chatNo;
	}

	public String getuserNickName() {
		return userNickName;
	}

	public LocalDateTime getCharDate() {
		return charDate;
	}

	public String getContent() {
		return content;
	}

	public int getGroupNo() {
		return groupNo;
	}
	
	
}
