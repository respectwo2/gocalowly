package com.example.gocalowly.domain.food.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodLogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)")
	private int recodeId;
	
	private Date recodeDate;
	private String mealType;
	private String foodName;
	private int calorie;
	private UUID userId;
	
	public FoodLogEntity() {
		// TODO Auto-generated constructor stub
	}

	public FoodLogEntity(Date recodeDate, String mealType, String foodName, int calorie, UUID userId) {
		super();
		this.recodeDate = recodeDate;
		this.mealType = mealType;
		this.foodName = foodName;
		this.calorie = calorie;
		this.userId = userId;
	}

	public int getRecodeId() {
		return recodeId;
	}

	public Date getRecodeDate() {
		return recodeDate;
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
