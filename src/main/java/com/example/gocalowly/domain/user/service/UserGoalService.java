package com.example.gocalowly.domain.user.service;

import com.example.gocalowly.domain.group.dto.response.GroupRankResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.entity.UserGoalEntity;
import com.example.gocalowly.domain.user.repository.UserGoalRepository;
import com.example.gocalowly.domain.user.repository.UserRepository;
import com.example.gocalowly.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserGoalService {
    UserRepository userRepository;
    UserGoalRepository userGoalRepository;

    public UserGoalService(UserRepository userRepository, UserGoalRepository userGoalRepository) {
        this.userRepository = userRepository;
        this.userGoalRepository = userGoalRepository;
    }

    public GroupRankResponseDto getRankInGroup(UUID userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));

        List<Integer> groupCompleteDates = user.getGroup().getUsers().stream()
                .map(UserEntity::getCompleteCount)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int index = groupCompleteDates.indexOf(user.getCompleteCount()) + 1;

        return new GroupRankResponseDto(
                (index * 100) / groupCompleteDates.size());
    }

    // 한 달마다 유저 목표 테이블 초기화
    public void resetUserClearGoals() {
        userGoalRepository.deleteAll();

        userRepository.findAll().forEach(UserEntity::clearUserGoals);
    }

    // 매일 자정에 모든 유저에 대해 어제 목표를 달성했는 지 저장
    public void addAllUserGoals() {
        userRepository.findAll().forEach(userEntity -> {
            LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
            int totalCalorieInYesterday = userRepository.findYesterdayCalorieSumByUserId(userEntity.getUserId(),
                    yesterday.toLocalDate());

            UserGoalEntity userGoal = new UserGoalEntity(
                    yesterday, userEntity.getUserTargetcalorie() >= totalCalorieInYesterday);

            userEntity.addUserGoal(userGoal);
            userGoalRepository.save(userGoal);
        });
    }


}
