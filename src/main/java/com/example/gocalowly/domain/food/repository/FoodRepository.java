package com.example.gocalowly.domain.food.repository;

import com.example.gocalowly.domain.food.entity.FoodData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<FoodData, String> {
    @Query("SELECT f FROM FoodData f WHERE f.foodDataName LIKE CONCAT('%', :foodDataName, '%')")
    List<FoodData> searchByFoodName(@Param("foodDataName") String foodDataName);

}
