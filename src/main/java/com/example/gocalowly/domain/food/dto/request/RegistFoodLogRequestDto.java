package com.example.gocalowly.domain.food.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

//식사(음식) 등록해서 로그에 이용되는 DTO
public class RegistFoodLogRequestDto {
    @PastOrPresent
    private LocalDateTime recordDate;

    @Pattern(regexp = "^(아침|점심|저녁|간식)$", message = "식사 유형은 아침, 점심, 저녁, 간식 중 하나여야 해요")
    private String mealType;
    @NotBlank(message = "음식 이름을 입력하셔야해요")
    private String foodName;
    @Min(value = 1, message = "칼로리는 0 이상이어야 해요")
    @Max(value = 9999, message = "칼로리는 9999 이하여야 해요")
    private int calorie;

    public RegistFoodLogRequestDto() {
    }

    public RegistFoodLogRequestDto(LocalDateTime recordDate, String mealType, String foodName, int calorie) {
        super();
        this.recordDate = recordDate;
        this.mealType = mealType;
        this.foodName = foodName;
        this.calorie = calorie;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public String getMealType() {
        return mealType;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalorie() {
        return calorie;
    }
}
