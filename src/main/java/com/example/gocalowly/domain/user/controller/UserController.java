package com.example.gocalowly.domain.user.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.token.controller.TokenController;
import com.example.gocalowly.domain.token.exception.TokenException;
import com.example.gocalowly.domain.user.dto.request.LoginRequestDto;
import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.service.UserGoalService;
import com.example.gocalowly.domain.user.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {
	UserService userService;
	TokenController tokenController;
	private final static UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");
	
	public UserController(UserService userService, TokenController tokenController) {
		this.userService = userService;
		this.tokenController = tokenController;
	}
	
	@PostMapping("/target-calorie")
	public ResponseEntity<?> updateUserTargetCalorie(@RequestBody TargetCalorieRequestDto targetCalorieRequestDto) {

		try {
			userService.updateUserTargetCalorie(TEST_USERID, targetCalorieRequestDto);
			return ResponseEntity.ok("");
		}catch(Exception e) {
		return ResponseEntity.badRequest().body("");	
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody SignUpRequestDto signUpRequestDto) {
		try {
			userService.addUser(signUpRequestDto);
			return ResponseEntity.ok("");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session, HttpServletResponse response) {
		try{
			LoginResponseDto loginResponseDto = userService.loginUser(loginRequestDto);
			
			session.setAttribute("userId", loginResponseDto.getUserId());
			session.setAttribute("groupNo", loginResponseDto.getGroupNo());
			session.setAttribute("userNickname", loginResponseDto.getUserNickname());
			
			tokenController.setTokens(loginResponseDto.getUserId(), response);
					
			return ResponseEntity.ok("로그인 되었습니다!");
		}catch(NoSuchElementException e) {
			return ResponseEntity.ok("아이디 또는 비밀번호가 잘못되었습니다.");
		}catch(TokenException e) {
			return ResponseEntity.ok(e.getMessage()); 
		}
	}
}
