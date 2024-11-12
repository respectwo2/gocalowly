package com.example.gocalowly.domain.food.dto.response;

import java.util.Date;
import java.util.List;

//음식 기록과 함께 계산한 총 칼로리와 날짜를 반환하는 DTO
public class DailyFoodLogResponseDto {
 private Date date;
 private int totalCalories;
 private List<FoodEntry> foodEntries;
 //<아/점/저>와 음식 이름, 칼로리를 저장하는 객체
 public static class FoodEntry {
     private String mealType;
     private String foodName;
     private int calories;

 }

}
