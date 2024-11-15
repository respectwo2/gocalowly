package com.example.gocalowly.domain.user.dto.request;

// 회원가입때 사용되는 DTO
public class SignUpRequestDto {
	private String userNickName; //유저 닉네임
	private String userPassword; //유저 비밀번호
	private String userName; //유저 이름
	private String userPhoneNumber; //유저 번호
	private int userTargetCalorie; //목표 칼로리
	
	public SignUpRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public SignUpRequestDto(String userNickName, String userPassword, String userName, String userPhoneNumber,
			int userTargetCalorie) {
		super();
		this.userNickName = userNickName;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.userTargetCalorie = userTargetCalorie;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public int getUserTargetCalorie() {
		return userTargetCalorie;
	}
	
	
}
