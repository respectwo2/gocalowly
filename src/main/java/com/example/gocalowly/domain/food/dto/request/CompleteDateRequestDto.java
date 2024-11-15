package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;
import java.util.UUID;

//userNo와 날짜를 통해 성공여부를 반환하는 DTO
public class CompleteDateRequestDto {
	private UUID userId;
	private Date recodeDate; 
	//foodlog 테이블의 조인을 통해 sum 집계함수를 통해 성공 여부를 반환해야함
	public CompleteDateRequestDto(UUID userId, Date recodeDate) {
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
