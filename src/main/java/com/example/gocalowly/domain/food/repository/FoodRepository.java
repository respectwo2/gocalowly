package com.example.gocalowly.domain.food.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gocalowly.domain.food.entity.FoodData;

public interface FoodRepository extends JpaRepository<FoodData, String> {
	@Query("SELECT f FROM FoodData f WHERE f.foodDataName LIKE CONCAT('%', :foodDataName, '%')")
	List<FoodData> searchByFoodName(@Param("foodDataName") String foodDataName);

}
