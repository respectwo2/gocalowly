package com.example.gocalowly.domain.group.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gocalowly.domain.group.entity.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
	public static final int CALORIE_DIF = 100;
	
	@Query("SELECT g FROM GroupEntity g WHERE :userTargetcalorie BETWEEN g.calorieGoal AND g.calorieGoal+99")
	Optional<GroupEntity> findByUserCalorie(@Param("userTargetcalorie") int userTargetcalorie);
}
