package com.example.gocalowly.domain.user.dto.response;

import java.util.UUID;

//로그인에 성공한 이후 유저넘버와 닉네임을 응답할때 사용되는 DTO
public class LoginResponseDto {
	private UUID userId;
	private String userNickname;
	private int groupNo;
	
	public LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponseDto(String userNickname, UUID userId, int groupNo) {
		super();
		this.userNickname = userNickname;
		this.userId = userId;
		this.groupNo = groupNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public UUID getUserId() {
		return userId;
	}

	public int getGroupNo() {
		return groupNo;
	}
}
