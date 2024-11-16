package com.example.gocalowly.domain.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food")
public class FoodData {
	@Id
	private String foodDataCode;
	private String foodDataName;
	private int foodDataCalorie;
	
	public FoodData() {
		// TODO Auto-generated constructor stub
	}

	public FoodData(String foodDataCode, String foodDataName, int foodDataCalorie) {
		super();
		this.foodDataCode = foodDataCode;
		this.foodDataName = foodDataName;
		this.foodDataCalorie = foodDataCalorie;
	}

	public String getFoodDataCode() {
		return foodDataCode;
	}

	public String getFoodDataName() {
		return foodDataName;
	}

	public int getFoodDataCalorie() {
		return foodDataCalorie;
	}
	
	
	
}
