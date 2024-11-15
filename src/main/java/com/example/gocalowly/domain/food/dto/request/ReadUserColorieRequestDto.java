package com.example.gocalowly.domain.food.dto.request;

//userNo를 통해 목표 칼로리를 불러오는 DTO
public class ReadUserColorieRequestDto {
	private int userNo; 
	
	public ReadUserColorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public ReadUserColorieRequestDto(int userNo) {
		super();
		this.userNo = userNo;
	}


	public int getUserNo() {
		return userNo;
	}
	
	
}
