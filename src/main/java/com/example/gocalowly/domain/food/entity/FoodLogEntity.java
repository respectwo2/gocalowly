package com.example.gocalowly.domain.food.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_food_log")
public class FoodLogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)")
	private UUID recordId;
	
	private LocalDateTime recordDate;
	private String mealType;
	private String foodName;
	private int calorie;
	private UUID userId;
	
	public FoodLogEntity() {
		// TODO Auto-generated constructor stub
	}

	public FoodLogEntity(LocalDateTime recordDate, String mealType, String foodName, int calorie, UUID userId) {
		super();
		setRecordDate(recordDate);
		setMealType(mealType);
		setFoodName(foodName);
		setCalorie(calorie);
		setUserId(userId);
	}

	
	
	private void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}

	private void setMealType(String mealType) {
		this.mealType = mealType;
	}

	private void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	private void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	private void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getRecordId() {
		return recordId;
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

	public UUID getUserId() {
		return userId;
	}
	
	
}
