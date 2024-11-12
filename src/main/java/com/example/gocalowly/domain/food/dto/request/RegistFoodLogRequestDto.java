package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;

//식사(음식) 등록해서 로그에 이용되는 DTO
public class RegistFoodLogRequestDto {
	private Date recodeDate;
	private String mealType;
	private String foodName;
	private int calorie;
	private int userNo; //있긴 있는데 직접 입력받진않고, 컨트롤러에서 받아서 사용

}
