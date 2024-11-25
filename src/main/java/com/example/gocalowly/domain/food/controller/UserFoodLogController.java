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

@RestController
@RequestMapping("/api/user")
public class UserFoodLogController {

    private static final UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");
    UserFoodLogService userFoodLogService;

    public UserFoodLogController(UserFoodLogService userFoodLogService) {
        this.userFoodLogService = userFoodLogService;
    }

    @GetMapping("/target-calorie")
    public ResponseEntity<DailyCalorieSummaryResponseDto> findDaliyCalorieSummary() {
        DailyCalorieSummaryResponseDto response = userFoodLogService.findDailyCalorieSummary(TEST_USERID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/food-logs")
    public ResponseEntity<List<DailyFoodLogResponseDto>> findFoodLog() {
        List<DailyFoodLogResponseDto> response = userFoodLogService.findFoodLogs(TEST_USERID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/food-logs")
    public ResponseEntity<Void> addUserFoodLog(@RequestBody RegistFoodLogRequestDto registFoodLogRequestDto) {
        userFoodLogService.addUserFoodLog(registFoodLogRequestDto, TEST_USERID);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/goals")
    public ResponseEntity<DailyGoalStatusResponseDto> findDailyGoalStatus() {
        DailyGoalStatusResponseDto response = userFoodLogService.findDailyGoalStatus(TEST_USERID);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
