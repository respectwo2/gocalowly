package com.example.gocalowly.domain.food.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyFoodLogResponseDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;

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
		int userTargetCaloire = userFoodLogRepository.findTargetCalorieByUserId(userId);
		int totalCalories = userFoodLogRepository.findTodayCalorieSumByUserId(userId);

		return new DailyCalorieSummaryResponseDto(totalCalories, userTargetCaloire);
	}


	@Transactional(readOnly = true)
	public List<DailyFoodLogResponseDto> findFoodLogs(UUID userId) {
		// 이번 달의 FoodLog 조회

		LocalDateTime startOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
		LocalDateTime endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()).atTime(23, 59, 59);
		List<FoodLogEntity> foodLogs = userFoodLogRepository.findByUserIdAndCurrentMonthWithOrder(userId, startOfMonth,
				endOfMonth);

		// 날짜별로 FoodLog 그룹화
		Map<LocalDate, List<FoodLogEntity>> groupedByDate = foodLogs.stream()
				.collect(Collectors.groupingBy(log -> log.getRecordDate().toLocalDate()));

		// 날짜별로 DTO 생성
		return groupedByDate.entrySet().stream().map(entry -> {
			LocalDateTime dateTime = entry.getKey().atStartOfDay();
			List<FoodLogEntity> logsForDate = entry.getValue();

			// FoodEntry 리스트 생성 및 총 칼로리 계산을 한 번의 Stream으로 처리
			int totalCalories[] = { 0 }; // 캡슐화
			List<DailyFoodLogResponseDto.FoodEntry> foodEntries = logsForDate.stream().map(log -> {
				totalCalories[0] += log.getCalorie();
				return new DailyFoodLogResponseDto.FoodEntry(log.getMealType(), log.getFoodName(), log.getCalorie());
			}).toList();

			return new DailyFoodLogResponseDto(dateTime, totalCalories[0], foodEntries);
		}).toList();

	
	public void addUserFoodLog(RegistFoodLogRequestDto registFoodLogRequestDto, UUID userID) {
		System.out.println(registFoodLogRequestDto.getCalorie());
		userFoodLogRepository.save(
				foodLogMapper.dtoToEntity(registFoodLogRequestDto, userID));

	}
}
