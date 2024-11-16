package com.example.gocalowly.domain.food.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.food.dto.request.ReadUserColorieRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.service.UserFoodLogService;

@RestController
@RequestMapping("/api/user")
public class UserFoodLogController {
	UserFoodLogService userFoodLogService;
	
	public UserFoodLogController(UserFoodLogService userFoodLogService) {
		this.userFoodLogService = userFoodLogService;
	}
	
	@GetMapping("/target-calorie")
	public ResponseEntity<DailyCalorieSummaryResponseDto> findDaliyCalorieSummary() {
		UUID userId = UUID.fromString("00000000-0000-0000-0000-000000000051");
		
		return ResponseEntity.ok(
				userFoodLogService.findDailyCalorieSummary(new ReadUserColorieRequestDto(userId)));
	}
}
