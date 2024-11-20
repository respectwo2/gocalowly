package com.example.gocalowly.domain.user.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.group.repository.GroupRepository;
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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserSaltRepository userSaltRepository;
    private final UserMapper userMapper;
    private final GroupRepository groupRepository;

    public UserService(UserRepository userRepository, UserSaltRepository userSaltRespository,UserMapper userMapper, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.userSaltRepository = userSaltRespository;
        this.userMapper = userMapper;
        this.groupRepository = groupRepository;
    }  

    public void addUser(SignUpRequestDto signUpRequestDto) {
    	// 엔티티 생성
    	UserEntity user = userMapper.dtoToEntity(signUpRequestDto);

    	// 암호화 수행할 객체
        PasswordEncryptionResultDto encryptionResult = OpenCrypt.encryptPw(signUpRequestDto.getUserPassword());

        //엔티티로 변환 후 암호화 작업
        user.changePassword(encryptionResult.getHashedPassword());
        GroupEntity group = groupRepository.findByUserCalorie(signUpRequestDto.getUserTargetcalorie())
        		.orElseThrow(() -> new NoSuchElementException("해당 칼로리를 목표로 갖는 그룹이 존재하지 않습니다."));
        
        user.setGroup(group);
        user.setGroupMissions(group.getGroupMissions());
        
        userRepository.save(user);
        userSaltRepository.save(new UserSaltEntity(user.getUserId(), encryptionResult.getSalt()));
    }

    
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
    	UserEntity loginUser = userRepository.findByUserNickname(loginRequestDto.getUserNickname())
    			.orElseThrow(() -> new NoSuchElementException());
    	
    	String salt = userSaltRepository.findById(loginUser.getUserId())
    			.orElseThrow(() -> new NoSuchElementException())
    			.getSalt();
    	
    	String encryptPassword = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(loginRequestDto.getUserPassword(), salt));
    	
    	if (!loginUser.getUserPassword().equals(encryptPassword)) {
    		throw new NoSuchElementException();
    	}
    	
    	return new LoginResponseDto(
    			loginUser.getUserNickname(), loginUser.getUserId(), loginUser.getGroup().getgroupNo());
    }
    
    public void updateUserTargetCalorie(UUID userId, TargetCalorieRequestDto targetCalorieRequestDto) {
    	UserEntity user = userRepository.findById(userId)
    			.orElse(null // 여기서 예외 처리!!
    					);
    	
    	user.updateTargetCalorie(targetCalorieRequestDto.getUserTargetcalorie());
    }
}
