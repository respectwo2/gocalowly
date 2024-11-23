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
		List<FoodSearchResultResponseDto> response = foodService.searchFoodByName(foodName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		}
}
