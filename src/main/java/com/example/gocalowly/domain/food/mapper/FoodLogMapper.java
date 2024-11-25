package com.example.gocalowly.domain.food.mapper;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;
import org.springframework.stereotype.Component;

@Component
public class FoodLogMapper {

    public FoodLogEntity dtoToEntity(RegistFoodLogRequestDto request) {
        return new FoodLogEntity(
                request.getRecordDate(),
                request.getMealType(),
                request.getFoodName(),
                request.getCalorie()
        );
    }

}
