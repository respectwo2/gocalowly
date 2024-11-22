package com.example.gocalowly.domain.food.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.food.dto.response.FoodSearchResultResponseDto;
import com.example.gocalowly.domain.food.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {
	FoodService foodService;
	
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<FoodSearchResultResponseDto>> searchFood(@RequestParam("foodName") String foodName) {
		try {
		List<FoodSearchResultResponseDto> response = foodService.searchFoodByName(foodName);
		// 검색 결과 없을 경우 따로 처리할 수도 있어요
		return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		}
}
