package com.example.gocalowly.domain.food.entity;

import java.util.Date;

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
	private int userNo;
}
