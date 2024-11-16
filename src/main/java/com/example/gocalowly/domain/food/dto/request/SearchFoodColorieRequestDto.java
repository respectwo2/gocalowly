package com.example.gocalowly.domain.food.dto.request;

//푸드 네임을 통해 칼로리를 반환하는 DTO
public class SearchFoodColorieRequestDto {
	private String foodDataName;
	
	public SearchFoodColorieRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public SearchFoodColorieRequestDto(String foodDataName) {
		super();
		this.foodDataName = foodDataName;
	}

	public String getFoodDataName() {
		return foodDataName;
	}
	
	
}
