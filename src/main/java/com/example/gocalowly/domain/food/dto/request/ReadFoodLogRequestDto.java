package com.example.gocalowly.domain.food.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

//식사 내역을 불러올때 사용되는 DTO
public class ReadFoodLogRequestDto {
	private UUID userId; //조인으로 불러오기
	private LocalDateTime recodeDate;
	
	public ReadFoodLogRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ReadFoodLogRequestDto(UUID userId, LocalDateTime recodeDate) {
		super();
		this.userId = userId;
		this.recodeDate = recodeDate;
	}

	public UUID getUserId() {
		return userId;
	}

	public LocalDateTime getRecodeDate() {
		return recodeDate;
	}

	
}
