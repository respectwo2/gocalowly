package com.example.gocalowly.domain.food.mapper;

import java.util.UUID;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;

public class FoodLogMapper {
	
	public FoodLogEntity dtoToEntity(RegistFoodLogRequestDto request, UUID userId) {
		return new FoodLogEntity(
				request.getRecordDate(),
				request.getMealType(),
				request.getFoodName(),
				request.getCalorie(),
				userId
				);
		}

}
