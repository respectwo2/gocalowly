package com.example.gocalowly.domain.user.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.user.dto.request.LoginRequestDto;
import com.example.gocalowly.domain.user.dto.request.PasswordEncryptionResultDto;
import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.request.TargetCalorieRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.entity.UserSaltEntity;
import com.example.gocalowly.domain.user.mapper.UserMapper;
import com.example.gocalowly.domain.user.repository.UserRepository;
import com.example.gocalowly.domain.user.repository.UserSaltRepository;
import com.example.gocalowly.util.OpenCrypt;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserSaltRepository userSaltRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserSaltRepository userSaltRespository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userSaltRepository = userSaltRespository;
        this.userMapper = userMapper;
    }
    
    @Transactional
    public UserEntity addUser(SignUpRequestDto signUpRequestDto) {
    	// 엔티티 생성
    	UserEntity user = userMapper.dtoToEntity(signUpRequestDto);

    	// 암호화 수행할 객체
        PasswordEncryptionResultDto encryptionResult = OpenCrypt.encryptPw(signUpRequestDto.getUserPassword());

        //엔티티로 변환 후 암호화 작업
        user.changePassword(encryptionResult.getHashedPassword());

        // 저장 작업
        UserEntity user1 = userRepository.save(user);
        userRepository.flush(); // 영속성 컨텍스트에서 DB로 플러시
        userSaltRepository.save(new UserSaltEntity(user1.getUserId(), encryptionResult.getSalt()));
        return user1;
    }

    
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto, int groupNo) {
    	return userMapper.entityToDto(
    			userRepository.findByUserNicknameAndUserPassword(
    			loginRequestDto.getUserNickname(), loginRequestDto.getUserPassword())
    			.orElse(null // 여기에 에러 처리 들어갈 수도 있고 Repository랑 똑같이 Optional 들어갈 수 있어요.
    			), groupNo);
    }
    
    public void updateUserTargetCalorie(UUID userId, TargetCalorieRequestDto targetCalorieRequestDto) {
    	UserEntity user = userRepository.findById(userId)
    			.orElse(null // 여기서 예외 처리!!
    					);
    	
    	user.updateTargetCalorie(targetCalorieRequestDto.getUserTargetcalorie());
    }
}
