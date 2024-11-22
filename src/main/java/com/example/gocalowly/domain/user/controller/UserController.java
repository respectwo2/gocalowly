package com.example.gocalowly.domain.user.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.user.dto.request.LoginRequestDto;
import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
	UserService userService;
	private final static UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/target-calorie")
	public ResponseEntity<Void> updateUserTargetCalorie(@RequestBody TargetCalorieRequestDto targetCalorieRequestDto) {

		try {
			userService.updateUserTargetCalorie(TEST_USERID, targetCalorieRequestDto);
			//칼로리 조회 성공
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			//유효하지않은 데이터
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Void> signupUser(@RequestBody SignUpRequestDto signUpRequestDto) {
		try {
			userService.addUser(signUpRequestDto);
			//새로운 리소스 생성
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			//유효하지않은 입력 데이터
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
		try{
			LoginResponseDto loginResponseDto = userService.loginUser(loginRequestDto);
			
			session.setAttribute("userId", loginResponseDto.getUserId());
			session.setAttribute("groupNo", loginResponseDto.getGroupNo());
			session.setAttribute("userNickname", loginResponseDto.getUserNickname());
			//성공
			return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
		}catch(NoSuchElementException e) {
			//비인증된 사용자
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
