package com.example.gocalowly.domain.food.repository;

import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;


public interface UserFoodLogRepository extends JpaRepository<FoodLogEntity, UUID> {
//    @Query("SELECT new DailyCalorieSummaryResponseDto(u.userTargetcalorie, IFNULL(SUM(fl.calorie), 0))"
//    		+ " FROM UserEntity u"
//    		+ " LEFT JOIN FoodLogEntity fl ON u.userId = fl.userId"
//    		+ " WHERE u.userId = :userId AND DATE(fl.recordDate) = CURDATE()")
//    DailyCalorieSummaryResponseDto findTargetCalorieByUserId(@Param("userId") UUID userId);
    
    
    @Query("SELECT u.userTargetcalorie FROM UserEntity u WHERE u.userId = :userId")
    int findTargetCalorieByUserId(@Param("userId") UUID userId);
    
    @Query("SELECT IFNULL(SUM(calorie), 0) FROM FoodLogEntity fl WHERE fl.userId = :userId AND DATE(fl.recordDate) = CURDATE()")
    int findTodayCalorieSumByUserId(@Param("userId") UUID userId);
}
