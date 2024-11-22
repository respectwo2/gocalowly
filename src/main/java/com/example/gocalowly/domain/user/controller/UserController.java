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

import com.example.gocalowly.domain.token.controller.TokenController;
import com.example.gocalowly.domain.token.exception.TokenException;
import com.example.gocalowly.domain.user.dto.request.LoginRequestDto;
import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	public ResponseEntity<Void> signupUser(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
	    System.out.println("DTO 유효성 검사 시작"); // 유효성 검사 확인용 로그
		userService.addUser(signUpRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/login")

	public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session, HttpServletResponse response) {

		try{
			LoginResponseDto loginResponseDto = userService.loginUser(loginRequestDto);
			
			session.setAttribute("userId", loginResponseDto.getUserId());
			session.setAttribute("groupNo", loginResponseDto.getGroupNo());
			session.setAttribute("userNickname", loginResponseDto.getUserNickname());
			
			tokenController.setTokens(loginResponseDto.getUserId(), response);
			//성공
			return ResponseEntity.status(HttpStatus.OK).body(loginResponseDto);
		}catch(NoSuchElementException e) {
			//비인증된 사용자
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

		}
	}
}
