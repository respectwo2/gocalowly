package com.example.gocalowly.domain.food.dto.request;

import java.util.UUID;

//userNo를 통해 목표 칼로리를 불러오는 DTO
public class ReadUserColorieRequestDto {
	private UUID userId; 
	
	public ReadUserColorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ReadUserColorieRequestDto(UUID userId) {
		super();
		this.userId = userId;
	}


	public UUID getUserId() {
		return userId;
	}
	
	
}
