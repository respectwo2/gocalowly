package com.example.gocalowly.domain.food.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.example.gocalowly.domain.user.entity.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	public FoodLogEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	UserEntity user;

	public FoodLogEntity(LocalDateTime recordDate, String mealType, String foodName, int calorie) {
		super();
		setRecordDate(recordDate);
		setMealType(mealType);
		setFoodName(foodName);
		setCalorie(calorie);
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
	
	public void setUser(UserEntity user) {
		this.user = user;
		user.addFoodLog(this);
	}
	
	public UserEntity getUser() {
		return user;
	}
}
