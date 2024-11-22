package com.example.gocalowly.domain.user.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

//한달마다 목표 칼로리를 질문할때 사용되는 DTO입니다
public class TargetCalorieRequestDto {
    @Min(value = 1000, message = "목표 칼로리는 1000 이상이어야 해요")
    @Max(value = 9999, message = "목표 칼로리는 9999 이하여야 해요")
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
