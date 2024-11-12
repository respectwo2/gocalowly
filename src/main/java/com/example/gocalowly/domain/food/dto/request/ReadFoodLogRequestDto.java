package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;

//식사 내역을 불러올때 사용되는 DTO
public class ReadFoodLogRequestDto {
	private int userNo; //조인으로 불러오기
	private Date recodeDate;
}
