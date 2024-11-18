package com.example.gocalowly.domain.user.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/target-calorie")
	public ResponseEntity<?> updateUserTargetCalorie(@RequestBody TargetCalorieRequestDto targetCalorieRequestDto) {
		UUID testUserUUID= UUID.fromString("00000000-0000-0000-0000-000000000001");

		try {
			userService.updateUserTargetCalorie(testUserUUID, targetCalorieRequestDto);
			return ResponseEntity.ok("");
		}catch(Exception e) {
		return ResponseEntity.badRequest().body("");	
		}
	}
}
