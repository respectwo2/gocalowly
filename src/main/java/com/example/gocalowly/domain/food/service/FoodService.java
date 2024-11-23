package com.example.gocalowly.domain.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.food.dto.response.FoodSearchResultResponseDto;
import com.example.gocalowly.domain.food.mapper.FoodMapper;
import com.example.gocalowly.domain.food.repository.FoodRepository;

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
