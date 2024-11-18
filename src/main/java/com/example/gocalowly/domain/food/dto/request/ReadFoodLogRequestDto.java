package com.example.gocalowly.domain.food.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

//식사 내역을 불러올때 사용되는 DTO
public class ReadFoodLogRequestDto {
	private LocalDateTime recordDate;
	
	public ReadFoodLogRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ReadFoodLogRequestDto(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}

	public LocalDateTime getRecordDate() {
		return recordDate;
	}

	
}
