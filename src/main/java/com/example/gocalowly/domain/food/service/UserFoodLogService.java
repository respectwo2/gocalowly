package com.example.gocalowly.domain.food.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyFoodLogResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyGoalStatusResponseDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;

import com.example.gocalowly.domain.food.mapper.FoodLogMapper;
import com.example.gocalowly.domain.food.repository.FoodRepository;
import com.example.gocalowly.domain.food.repository.UserFoodLogRepository;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class UserFoodLogService {
	UserFoodLogRepository userFoodLogRepository;
	FoodLogMapper foodLogMapper;
	UserRepository userRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserFoodLogService(UserFoodLogRepository userFoodLogRepository, FoodLogMapper foodLogMapper, UserRepository userRepository) {
		this.userFoodLogRepository = userFoodLogRepository;
		this.foodLogMapper = foodLogMapper;
		this.userRepository = userRepository;
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
	}
  
	public void addUserFoodLog(RegistFoodLogRequestDto registFoodLogRequestDto, UUID userId) {		
		FoodLogEntity foodLog = foodLogMapper.dtoToEntity(registFoodLogRequestDto);
		foodLog.setUser(entityManager.getReference(UserEntity.class, userId));
		
		userFoodLogRepository.save(foodLog);
	}
	
	public DailyGoalStatusResponseDto findDailyGoalStatus(UUID userId) {
        LocalDateTime startOfWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
        LocalDateTime endOfWeek = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).atTime(23, 59, 59);
        
		List<FoodLogEntity> foodLogs = userFoodLogRepository.findByUserIdAndCurrentMonthWithOrder(userId, startOfWeek, endOfWeek);
		
		List<LocalDate> allDatesOfWeek = new ArrayList<>();
		LocalDate currentDate = startOfWeek.toLocalDate();
		LocalDate endDate = endOfWeek.toLocalDate();

		while (!currentDate.isAfter(endDate)) {
		    allDatesOfWeek.add(currentDate);
		    currentDate = currentDate.plusDays(1); // 하루씩 증가
		}

        // 기본 맵 생성 (빈 리스트로 초기화)
        Map<LocalDate, List<FoodLogEntity>> groupedByDate = allDatesOfWeek.stream()
                .collect(Collectors.toMap(date -> date, date -> new ArrayList<>()));

        // 실제 데이터를 날짜별로 그룹화
        Map<LocalDate, List<FoodLogEntity>> actualGroupedData = foodLogs.stream()
                .collect(Collectors.groupingBy(log -> log.getRecordDate().toLocalDate()));

        // 기본 맵에 실제 데이터 병합
        actualGroupedData.forEach((date, logs) -> groupedByDate.get(date).addAll(logs));
        
        int targetCalorie = userRepository.findById(userId)
        		.orElseThrow(() -> new NoSuchElementException("해당하는 유저가 존재하지 않습니다."))
        		.getUserTargetcalorie();
        
        return new DailyGoalStatusResponseDto(actualGroupedData.entrySet().stream().map(entry -> {
        	LocalDateTime date = entry.getKey().atStartOfDay();
        	int calorieSum = entry.getValue().stream().mapToInt(foodLog -> foodLog.getCalorie()).sum();
        	boolean isGoal = false;
        	
        	if (targetCalorie >= calorieSum) {
        		isGoal = true;
        	}
        	
        	return new DailyGoalStatusResponseDto.DailyGoal(date, isGoal);
        	})
        	.toList());
	}
}
