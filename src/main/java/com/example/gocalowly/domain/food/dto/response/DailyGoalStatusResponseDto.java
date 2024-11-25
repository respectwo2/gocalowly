package com.example.gocalowly.domain.food.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

//날짜에 따라 미션을 성공했는지 안했는지 반환하는 DTO
public class DailyGoalStatusResponseDto {
    private final List<DailyGoal> dailyGoals;

    public DailyGoalStatusResponseDto(List<DailyGoal> dailyGoals) {
        this.dailyGoals = dailyGoals;
    }

    public List<DailyGoal> getDailyGoals() {
        return dailyGoals;
    }

    public static class DailyGoal {
        private final LocalDateTime date;     // 날짜
        @JsonProperty("isGoal")
        private final boolean isGoal;  // 목표 달성 여부 (true: 목표 달성, false: 미달성)

        public DailyGoal(LocalDateTime date, boolean isGoal) {
            this.date = date;
            this.isGoal = isGoal;
        }

        public LocalDateTime getDate() {
            return date;
        }

        @JsonProperty("isGoal")
        public boolean isGoal() {
            return isGoal;
        }
    }
}
