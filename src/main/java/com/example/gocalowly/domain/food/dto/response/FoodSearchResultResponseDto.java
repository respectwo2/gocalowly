package com.example.gocalowly.domain.food.dto.response;

//검색 결과의 이름과 칼로리를 반환하는 DTO
//LIKE %%로 쿼리로 가져온다
public class FoodSearchResultResponseDto {
	private String foodDataName;
	private int foodDataCalorie;
}
