package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;
import java.util.UUID;

//식사 내역을 불러올때 사용되는 DTO
public class ReadFoodLogRequestDto {
	private UUID userId; //조인으로 불러오기
	private Date recodeDate;
	
	public ReadFoodLogRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ReadFoodLogRequestDto(UUID userId, Date recodeDate) {
		super();
		this.userId = userId;
		this.recodeDate = recodeDate;
	}

	public UUID getUserId() {
		return userId;
	}

	public Date getRecodeDate() {
		return recodeDate;
	}

	
}
