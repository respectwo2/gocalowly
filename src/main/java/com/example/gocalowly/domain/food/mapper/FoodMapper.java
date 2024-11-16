package com.example.gocalowly.domain.food.mapper;

import org.springframework.stereotype.Component;

import com.example.gocalowly.domain.food.dto.response.FoodSearchResultResponseDto;
import com.example.gocalowly.domain.food.entity.FoodData;

@Component
public class FoodMapper {
	public FoodSearchResultResponseDto entityToDto(FoodData foodData) {
		return new FoodSearchResultResponseDto(
				foodData.getFoodDataName(),
				foodData.getFoodDataCalorie());
	}
}
