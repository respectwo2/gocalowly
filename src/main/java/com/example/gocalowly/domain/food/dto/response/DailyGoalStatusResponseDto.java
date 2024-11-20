package com.example.gocalowly.domain.food.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//날짜에 따라 미션을 성공했는지 안했는지 반환하는 DTO
public class DailyGoalStatusResponseDto {
	private List<DailyGoal> dailyGoals;
	
	public DailyGoalStatusResponseDto(List<DailyGoal> dailyGoals) {
		this.dailyGoals = dailyGoals;
	}
	
	public List<DailyGoal> getDailyGoals() {
		return dailyGoals;
	}
	
	public static class DailyGoal {
	    private LocalDateTime date;     // 날짜
	    @JsonProperty("isGoal")
	    private boolean isGoal;  // 목표 달성 여부 (true: 목표 달성, false: 미달성)
    
	    public DailyGoal(LocalDateTime date, boolean isGoal) {
	    	this.date = date;
	    	this.isGoal = isGoal;
		}
	    
		public LocalDateTime getDate() {
			return date;
		}
	
		@JsonProperty("isGoal")
		public boolean isGoal() {
			return isGoal;
		}
	}
}