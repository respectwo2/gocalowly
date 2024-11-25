package com.example.gocalowly.domain.food.mapper;

import com.example.gocalowly.domain.food.dto.response.FoodSearchResultResponseDto;
import com.example.gocalowly.domain.food.entity.FoodData;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {
    public FoodSearchResultResponseDto entityToDto(FoodData foodData) {
        return new FoodSearchResultResponseDto(
                foodData.getFoodDataName(),
                foodData.getFoodDataCalorie());
    }
}
