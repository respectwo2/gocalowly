package com.example.gocalowly.domain.user.mapper;

import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;

public class UserMapper {
	// 회원가입으로 유저 객체 생성
	public UserEntity dtoToEntity(SignUpRequestDto request) {
		return new UserEntity(request.getUserNickName(),
				request.getUserPassword(),
				request.getUserName(),
				request.getUserPhoneNumber(),
				request.getUserTargetCalorie()
				);
	}

	// 유저로 로그인 객체 생성
	public LoginResponseDto entityToDto(UserEntity user) {
		return new LoginResponseDto(user.getUserId(),
				user.getUserNickName()
				);
	}

}
