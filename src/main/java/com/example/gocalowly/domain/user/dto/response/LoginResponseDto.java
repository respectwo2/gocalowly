package com.example.gocalowly.domain.user.dto.response;

import java.util.UUID;

//로그인에 성공한 이후 유저넘버와 닉네임을 응답할때 사용되는 DTO
public class LoginResponseDto {
	private String userNickname;
	
	public LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}
	public LoginResponseDto(String userNickname) {
		super();
		this.userNickname = userNickname;
	}

	public String getUserNickname() {
		return userNickname;
	}
}
