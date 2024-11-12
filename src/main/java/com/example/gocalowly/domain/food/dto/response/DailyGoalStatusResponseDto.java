package com.example.gocalowly.domain.food.dto.response;

import java.util.Date;

//날짜에 따라 미션을 성공했는지 안했는지 반환하는 DTO
public class DailyGoalStatusResponseDto {
    private Date date;     // 날짜
    private boolean isGoal;  // 목표 달성 여부 (true: 목표 달성, false: 미달성)

}