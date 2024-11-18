package com.example.gocalowly.domain.food.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyFoodLogResponseDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;
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
	
    @Transactional(readOnly = true)
    public DailyFoodLogResponseDto findFoodLog(UUID userId) {
        // 오늘 날짜 기준 데이터 조회
        List<FoodLogEntity> foodLogs = userFoodLogRepository.findByUserIdAndCurrentMonth(userId);
        // 총 칼로리 계산
        
        Stream<LocalDateTime> date = foodLogs.stream().map(FoodLogEntity::getRecordDate);
        int totalCalories = foodLogs.stream().mapToInt(FoodLogEntity::getCalorie).sum();

        // FoodEntry 리스트 생성
        List<DailyFoodLogResponseDto.FoodEntry> foodEntries = foodLogs.stream()
            .map(foodEntry -> new DailyFoodLogResponseDto.FoodEntry(
                foodEntry.getMealType(),
                foodEntry.getFoodName(),
                foodEntry.getCalorie()
            )).toList();

        // 응답 DTO 생성
        return new DailyFoodLogResponseDto(date, totalCalories, foodEntries);
	
    }
}
