package com.example.gocalowly.domain.food.dto.response;

import java.time.LocalDateTime;
import java.util.List;

//음식 기록과 함께 계산한 총 칼로리와 날짜를 반환하는 DTO
public class DailyFoodLogResponseDto {
    private LocalDateTime date;
    private int totalCalories;
    private List<FoodEntry> foodEntries;

    public DailyFoodLogResponseDto() {
    }

    public DailyFoodLogResponseDto(LocalDateTime date, int totalCalories, List<FoodEntry> foodEntries) {
        super();
        this.date = date;
        this.totalCalories = totalCalories;
        this.foodEntries = foodEntries;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public List<FoodEntry> getFoodEntries() {
        return foodEntries;
    }

    // <아/점/저>와 음식 이름, 칼로리를 저장하는 객체
    public static class FoodEntry {
        private String mealType;
        private String foodName;
        private int calories;

        public FoodEntry() {
        }

        public FoodEntry(String mealType, String foodName, int calories) {
            super();
            this.mealType = mealType;
            this.foodName = foodName;
            this.calories = calories;
        }

        public String getMealType() {
            return mealType;
        }

        public String getFoodName() {
            return foodName;
        }

        public int getCalories() {
            return calories;
        }


    }

}
