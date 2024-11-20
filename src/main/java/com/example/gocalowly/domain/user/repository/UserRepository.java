package com.example.gocalowly.domain.user.repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	// 회원가입에 이용되는 save(userEntity) 는 자동으로 생성
	// 목표 칼로리, 금일 총 칼로리 조회에 이용되는 findById 는 자동으로 생성 -> 이것도 Optional로 구현해서 null값은 제외
	
	Optional<UserEntity> findByUserNicknameAndUserPassword(String userNickname, String userPassword);
	
	@Query("SELECT u FROM UserEntity u JOIN FETCH u.userGroupMissions um JOIN FETCH um.groupMission WHERE u.userId = :userId")
	Optional<UserEntity> findByIdWithMissions(@Param("userId") UUID userId);
	
    @Query("SELECT IFNULL(SUM(calorie), 0) FROM FoodLogEntity fl WHERE fl.user.userId = :userId AND DATE(fl.recordDate) = :yesterday")
    int findYesterdayCalorieSumByUserId(@Param("userId") UUID userId, @Param("yesterday") LocalDate yesterday);
	
//    @Modifying
//    @Transactional
//    @Query("UPDATE UserEntity u SET u.userTargetcalorie = :targetCalorie WHERE u.userId = :userId")
//    int updateUserTargetCalorie(@Param("userId") UUID userId, 
//                                @Param("targetCalorie") int targetCalorie);
}
