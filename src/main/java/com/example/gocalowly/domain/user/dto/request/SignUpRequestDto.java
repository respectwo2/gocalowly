package com.example.gocalowly.domain.user.dto.request;

// 회원가입때 사용되는 DTO
public class SignUpRequestDto {
	private String userNickname; //유저 닉네임
	private String userPassword; //유저 비밀번호
	private String userName; //유저 이름
	private String userPhonenumber; //유저 번호
	private int userTargetcalorie; //목표 칼로리
	
	public SignUpRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public SignUpRequestDto(String userNickname, String userPassword, String userName, String userPhonenumber,
			int userTargetcalorie) {
		super();
		this.userNickname = userNickname;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhonenumber = userPhonenumber;
		this.userTargetcalorie = userTargetcalorie;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhonenumber() {
		return userPhonenumber;
	}

	public int getUserTargetcalorie() {
		return userTargetcalorie;
	}
	
	
}
