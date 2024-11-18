package com.example.gocalowly.domain.food.dto.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

//식사(음식) 등록해서 로그에 이용되는 DTO
public class RegistFoodLogRequestDto {
	private LocalDateTime recordDate;
	private String mealType;
	private String foodName;
	private int calorie;

	public RegistFoodLogRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistFoodLogRequestDto(LocalDateTime recordDate, String mealType, String foodName, int calorie) {
		super();
		this.recordDate = recordDate;
		this.mealType = mealType;
		this.foodName = foodName;
		this.calorie = calorie;
	}

	public LocalDateTime getRecordDate() {
		return recordDate;
	}

	public String getMealType() {
		return mealType;
	}

	public String getFoodName() {
		return foodName;
	}

	public int getCalorie() {
		return calorie;
	}
}
