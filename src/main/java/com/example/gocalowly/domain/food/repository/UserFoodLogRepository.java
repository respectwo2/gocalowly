package com.example.gocalowly.domain.food.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.entity.FoodData;
import com.example.gocalowly.domain.food.entity.FoodLogEntity;

public interface UserFoodLogRepository extends JpaRepository<FoodLogEntity, UUID> {
//    @Query("SELECT new DailyCalorieSummaryResponseDto(u.user_targetcalorie, SUM(uf.calorie))"
//    		+ " FROM User u"
//    		+ " LEFT JOIN UserFoodLog uf ON u.user_id = uf.user_id"
//    		+ " WHERE u.user_id = :userId AND uf.recode_date = CURDATE()")
//    DailyCalorieSummaryResponseDto findTargetCalorieByUserId(@Param("userId") UUID userId);
    
    
    @Query("SELECT u.userTargetcalorie FROM UserEntity u WHERE u.userId = :userId")
    int findTargetCalorieByUserId(@Param("userId") UUID userId);
    
    @Query("SELECT IFNULL(SUM(calorie), 0) FROM FoodLogEntity fl WHERE fl.userId = :userId AND fl.recordDate = CURDATE()")
    int findTodayCalorieSumByUserId(@Param("userId") UUID userId);
    
//    @Query("SELECT f FROM FoodLogEntity f WHERE f.userId = :userId AND f.recordDate BETWEEN :startOfMonth AND :endOfMonth " )
//    List<FoodLogEntity> findByUserIdAndMonth(@Param("userId") UUID userId, 
//                                             @Param("startOfMonth") LocalDateTime startOfMonth, 
//                                             @Param("endOfMonth") LocalDateTime endOfMonth);

    
    @Query("SELECT f FROM FoodLogEntity f WHERE f.userId = :userId AND FUNCTION('YEAR', f.recordDate) = FUNCTION('YEAR', CURRENT_DATE) AND FUNCTION('MONTH', f.recordDate) = FUNCTION('MONTH', CURRENT_DATE)")
    List<FoodLogEntity> findByUserIdAndCurrentMonth(@Param("userId") UUID userId);


}
