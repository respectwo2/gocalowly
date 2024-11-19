package com.example.gocalowly.domain.food.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyFoodLogResponseDto;
import com.example.gocalowly.domain.food.service.UserFoodLogService;

@RestController
@RequestMapping("/api/user")
public class UserFoodLogController {
	UserFoodLogService userFoodLogService;
	
	static final UUID testUserId = UUID.fromString("00000000-0000-0000-0000-000000000001");
	
	public UserFoodLogController(UserFoodLogService userFoodLogService) {
		this.userFoodLogService = userFoodLogService;
	}
	
	@GetMapping("/target-calorie")
	public ResponseEntity<DailyCalorieSummaryResponseDto> findDaliyCalorieSummary() {
		UUID testUserId = UUID.fromString("00000000-0000-0000-0000-000000000001");

		
		return ResponseEntity.ok(
				userFoodLogService.findDailyCalorieSummary(testUserId));
	}
	

	@GetMapping("food-logs")
	public ResponseEntity<List<DailyFoodLogResponseDto>> findFoodLog(){
		
		return ResponseEntity.ok(
				userFoodLogService.findFoodLogs(testUserId)
				);
	}

	@PostMapping("/food-logs")
	public ResponseEntity<String> addUserFoodLog(@RequestBody RegistFoodLogRequestDto registFoodLogRequestDto){
		
		userFoodLogService.addUserFoodLog(registFoodLogRequestDto, testUserId);
		
		return ResponseEntity.ok("");

	}
}
