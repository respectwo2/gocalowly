package com.example.gocalowly.domain.user.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.user.dto.request.LoginRequestDto;
import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.mapper.UserMapper;
import com.example.gocalowly.domain.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    
    public void addUser(SignUpRequestDto signUpRequestDto) {
    	// 여기에서 회원가입에 대한 예외 처리
    	
    	userRepository.save(userMapper.dtoToEntity(signUpRequestDto));
    }
    
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
    	return userMapper.entityToDto(
    			userRepository.findByUserNicknameAndUserPassword(
    			loginRequestDto.getUserNickname(), loginRequestDto.getUserPassword())
    			.orElse(null // 여기에 에러 처리 들어갈 수도 있고 Repository랑 똑같이 Optional 들어갈 수 있어요.
    			));
    }
    
    public void updateUserTargetCalorie(UUID userId, TargetCalorieRequestDto targetCalorieRequestDto) {
    	UserEntity user = userRepository.findById(userId)
    			.orElse(null // 여기서 예외 처리!!
    					);
    	
    	user.updateTargetCalorie(targetCalorieRequestDto.getUserTargetcalorie());
    }
}
