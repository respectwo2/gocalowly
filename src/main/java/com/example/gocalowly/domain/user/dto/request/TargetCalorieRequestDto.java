package com.example.gocalowly.domain.user.dto.request;

//한달마다 목표 칼로리를 질문할때 사용되는 DTO입니다
public class TargetCalorieRequestDto {
	private int userNo;
	private String userTargetCalorie;
	
	public TargetCalorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public TargetCalorieRequestDto(int userNo, String userTargetCalorie) {
		super();
		this.userNo = userNo;
		this.userTargetCalorie = userTargetCalorie;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserTargetCalorie() {
		return userTargetCalorie;
	}
	

}
