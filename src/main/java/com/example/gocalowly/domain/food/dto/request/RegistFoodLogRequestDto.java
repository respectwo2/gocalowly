package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;
import java.util.UUID;

//식사(음식) 등록해서 로그에 이용되는 DTO
public class RegistFoodLogRequestDto {
	private Date recodeDate;
	private String mealType;
	private String foodName;
	private int calorie;
	private UUID userId; //있긴 있는데 직접 입력받진않고, 컨트롤러에서 받아서 사용

	public RegistFoodLogRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistFoodLogRequestDto(Date recodeDate, String mealType, String foodName, int calorie, UUID userId) {
		super();
		this.recodeDate = recodeDate;
		this.mealType = mealType;
		this.foodName = foodName;
		this.calorie = calorie;
		this.userId = userId;
	}

	public Date getRecodeDate() {
		return recodeDate;
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

	public UUID getUserId() {
		return userId;
	}
	
}
