package com.example.gocalowly.domain.food.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.mapper.FoodLogMapper;
import com.example.gocalowly.domain.food.repository.UserFoodLogRepository;

@Service
public class UserFoodLogService {
	UserFoodLogRepository userFoodLogRepository;
	FoodLogMapper foodLogMapper;
	
	public UserFoodLogService(UserFoodLogRepository userFoodLogRepository, FoodLogMapper foodLogMapper) {
		this.userFoodLogRepository = userFoodLogRepository;
		this.foodLogMapper = foodLogMapper;
	}
	
	public DailyCalorieSummaryResponseDto findDailyCalorieSummary(UUID userId) {

		int todayTotalCalorie = userFoodLogRepository.findTodayCalorieSumByUserId(userId);
		int userTargetCalorie = userFoodLogRepository.findTargetCalorieByUserId(userId);
		
		
		return new DailyCalorieSummaryResponseDto(todayTotalCalorie, userTargetCalorie);
	}
	
	public void addUserFoodLog(RegistFoodLogRequestDto registFoodLogRequestDto, UUID userID) {
		System.out.println(registFoodLogRequestDto.getCalorie());
		userFoodLogRepository.save(
				foodLogMapper.dtoToEntity(registFoodLogRequestDto, userID));
	}
}
