package com.example.gocalowly.domain.user.dto.request;

import java.util.UUID;

//한달마다 목표 칼로리를 질문할때 사용되는 DTO입니다
public class TargetCalorieRequestDto {
	private UUID userId;
	private String userTargetCalorie;
	
	public TargetCalorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public TargetCalorieRequestDto(UUID userId, String userTargetCalorie) {
		super();
		this.userId = userId;
		this.userTargetCalorie = userTargetCalorie;
	}

	public UUID getUserId() {
		return userId;
	}

	public String getUserTargetCalorie() {
		return userTargetCalorie;
	}
}
