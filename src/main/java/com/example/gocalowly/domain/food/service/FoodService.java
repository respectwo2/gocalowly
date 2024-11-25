package com.example.gocalowly.domain.food.service;

import com.example.gocalowly.domain.food.dto.response.FoodSearchResultResponseDto;
import com.example.gocalowly.domain.food.mapper.FoodMapper;
import com.example.gocalowly.domain.food.repository.FoodRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    FoodMapper foodMapper;
    FoodRepository foodRepository;

    public FoodService(FoodMapper foodMapper, FoodRepository foodRepository) {
        this.foodMapper = foodMapper;
        this.foodRepository = foodRepository;
    }


    public List<FoodSearchResultResponseDto> searchFoodByName(String name) {
        return foodRepository.searchByFoodName(name)
                .stream()
                .map(FoodData -> foodMapper.entityToDto(FoodData))
                .toList();
    }
}
