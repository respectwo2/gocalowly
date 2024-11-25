package com.example.gocalowly.domain.food.repository;

import com.example.gocalowly.domain.food.entity.FoodLogEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserFoodLogRepository extends JpaRepository<FoodLogEntity, UUID> {
//    @Query("SELECT new DailyCalorieSummaryResponseDto(u.userTargetcalorie, IFNULL(SUM(fl.calorie), 0))"
//    		+ " FROM UserEntity u"
//    		+ " LEFT JOIN FoodLogEntity fl ON u.userId = fl.userId"
//    		+ " WHERE u.userId = :userId AND DATE(fl.recordDate) = CURDATE()")
//    DailyCalorieSummaryResponseDto findTargetCalorieByUserId(@Param("userId") UUID userId);


    @Query("SELECT u.userTargetcalorie FROM UserEntity u WHERE u.userId = :userId")
    int findTargetCalorieByUserId(@Param("userId") UUID userId);

    @Query("SELECT IFNULL(SUM(calorie), 0) FROM FoodLogEntity fl WHERE fl.user.userId = :userId AND DATE(fl.recordDate) = CURDATE()")
    int findTodayCalorieSumByUserId(@Param("userId") UUID userId);


    //날짜를 기준으로 정렬하고, 날짜가 같다면 mealtype으로 정렬
    @Query("SELECT f FROM FoodLogEntity f " +
            "WHERE f.user.userId = :userId " +
            "AND f.recordDate BETWEEN :startOfMonth AND :endOfMonth " +
            "ORDER BY FUNCTION('DATE', f.recordDate), " +
            "CASE " +
            "WHEN f.mealType = '아침' THEN 1 " +
            "WHEN f.mealType = '점심' THEN 2 " +
            "WHEN f.mealType = '저녁' THEN 3 " +
            "ELSE 4 " +
            "END")
    List<FoodLogEntity> findByUserIdAndCurrentMonthWithOrder(
            @Param("userId") UUID userId,
            @Param("startOfMonth") LocalDateTime startOfMonth,
            @Param("endOfMonth") LocalDateTime endOfMonth
    );


}
