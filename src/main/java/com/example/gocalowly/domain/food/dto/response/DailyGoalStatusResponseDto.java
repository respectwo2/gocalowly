package com.example.gocalowly.domain.food.dto.response;

import java.time.LocalDateTime;

//날짜에 따라 미션을 성공했는지 안했는지 반환하는 DTO
public class DailyGoalStatusResponseDto {
    private LocalDateTime date;     // 날짜
    private boolean isGoal;  // 목표 달성 여부 (true: 목표 달성, false: 미달성)
    
    public DailyGoalStatusResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public DailyGoalStatusResponseDto(LocalDateTime date, boolean isGoal) {
		super();
		this.date = date;
		this.isGoal = isGoal;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public boolean isGoal() {
		return isGoal;
	}
    
    

}