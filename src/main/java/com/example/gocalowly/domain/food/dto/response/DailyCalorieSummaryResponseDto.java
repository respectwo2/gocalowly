package com.example.gocalowly.domain.food.dto.response;

//금일 섭취 칼로리와 목표한 칼로리를 반환하는 DTO
public class DailyCalorieSummaryResponseDto {
    private int totalCalories;       // 오늘 섭취한 총 칼로리
    private int userTargetCalorie;         // 설정된 목표 칼로리
    
    public DailyCalorieSummaryResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public DailyCalorieSummaryResponseDto(int totalCalories, int userTargetCalorie) {
		super();
		this.totalCalories = totalCalories;
		this.userTargetCalorie = userTargetCalorie;
	}

	public int getTotalCalories() {
		return totalCalories;
	}

	public int getUserTargetCalorie() {
		return userTargetCalorie;
	}

}

