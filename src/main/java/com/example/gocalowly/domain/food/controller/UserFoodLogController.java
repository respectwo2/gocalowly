package com.example.gocalowly.domain.food.controller;

import com.example.gocalowly.domain.food.dto.request.RegistFoodLogRequestDto;
import com.example.gocalowly.domain.food.dto.response.DailyCalorieSummaryResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyFoodLogResponseDto;
import com.example.gocalowly.domain.food.dto.response.DailyGoalStatusResponseDto;
import com.example.gocalowly.domain.food.service.UserFoodLogService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api/user")
public class UserFoodLogController {
    UserFoodLogService userFoodLogService;

    public UserFoodLogController(UserFoodLogService userFoodLogService) {
        this.userFoodLogService = userFoodLogService;
    }

    @GetMapping("/target-calorie")
    public ResponseEntity<DailyCalorieSummaryResponseDto> findDaliyCalorieSummary(@SessionAttribute UUID userId) {
        DailyCalorieSummaryResponseDto response = userFoodLogService.findDailyCalorieSummary(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/food-logs")
    public ResponseEntity<List<DailyFoodLogResponseDto>> findFoodLog(@SessionAttribute UUID userId) {
        List<DailyFoodLogResponseDto> response = userFoodLogService.findFoodLogs(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/food-logs")
    public ResponseEntity<Void> addUserFoodLog(@RequestBody RegistFoodLogRequestDto registFoodLogRequestDto, @SessionAttribute UUID userId) {
        userFoodLogService.addUserFoodLog(registFoodLogRequestDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/goals")
    public ResponseEntity<DailyGoalStatusResponseDto> findDailyGoalStatus(@SessionAttribute UUID userId) {
        DailyGoalStatusResponseDto response = userFoodLogService.findDailyGoalStatus(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
