package com.example.gocalowly.domain.user.dto.response;

import java.util.UUID;

//로그인에 성공한 이후 유저넘버와 닉네임을 응답할때 사용되는 DTO
public class LoginResponseDto {
	private UUID userId;
	private String userNickName;
	
	public LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}
	public LoginResponseDto(UUID userId, String userNickName) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
	}

	public UUID getUserId() {
		return userId;
	}

	public String getUserNickName() {
		return userNickName;
	}
	
	

}
