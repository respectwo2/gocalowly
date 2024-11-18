package com.example.gocalowly.domain.food.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.repository.UserFoodLogRepository;

@Service
public class UserFoodLogService {
	UserFoodLogRepository userFoodLogRepository;
	
	public UserFoodLogService(UserFoodLogRepository userFoodLogRepository) {
		this.userFoodLogRepository = userFoodLogRepository;
	}
	
	public DailyCalorieSummaryResponseDto findDailyCalorieSummary(UUID userId) {
		int userTargetCaloire = userFoodLogRepository.findTargetCalorieByUserId(userId);
		int totalCalories = userFoodLogRepository.findTodayCalorieSumByUserId(userId);
		
		return new DailyCalorieSummaryResponseDto(totalCalories, userTargetCaloire);
	}
}
