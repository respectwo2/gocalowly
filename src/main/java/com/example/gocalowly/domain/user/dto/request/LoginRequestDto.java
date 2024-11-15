package com.example.gocalowly.domain.user.dto.request;

//userNo와 nickname으로 응답
public class LoginRequestDto {
	private String userNickName; //유저 닉네임
	private String userPassword; //유저 패스워드
	
	public LoginRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginRequestDto(String userNickName, String userPassword) {
		super();
		this.userNickName = userNickName;
		this.userPassword = userPassword;
	}

	public String getUserNickName() {
		return userNickName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	

}
