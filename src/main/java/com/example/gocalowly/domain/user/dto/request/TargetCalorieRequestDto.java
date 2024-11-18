package com.example.gocalowly.domain.user.dto.request;

import java.util.UUID;

//한달마다 목표 칼로리를 질문할때 사용되는 DTO입니다
public class TargetCalorieRequestDto {
	private int userTargetcalorie;
	
	public TargetCalorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public TargetCalorieRequestDto(int userTargetcalorie) {
		super();
		this.userTargetcalorie = userTargetcalorie;
	}

	public int getUserTargetcalorie() {
		return userTargetcalorie;
	}
}
