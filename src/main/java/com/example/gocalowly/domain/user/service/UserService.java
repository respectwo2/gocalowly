package com.example.gocalowly.domain.user.service;

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
import com.example.gocalowly.exception.AuthenticationFailedException;
import com.example.gocalowly.exception.ResourceNotFoundException;
import com.example.gocalowly.util.OpenCrypt;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;
	private final UserSaltRepository userSaltRepository;
	private final UserMapper userMapper;
	private final GroupRepository groupRepository;

	public UserService(UserRepository userRepository, UserSaltRepository userSaltRespository, UserMapper userMapper,
			GroupRepository groupRepository) {
		this.userRepository = userRepository;
		this.userSaltRepository = userSaltRespository;
		this.userMapper = userMapper;
		this.groupRepository = groupRepository;
	}

	public void addUser(SignUpRequestDto signUpRequestDto) {
		UserEntity user = userMapper.dtoToEntity(signUpRequestDto);

		PasswordEncryptionResultDto encryptionResult = OpenCrypt.encryptPw(signUpRequestDto.getUserPassword());
		user.changePassword(encryptionResult.getHashedPassword());
		
		GroupEntity group = groupRepository.findByUserCalorie(signUpRequestDto.getUserTargetcalorie())
				.orElseThrow(() -> new ResourceNotFoundException("GROUP_NOT_FOUND"));

		user.setGroup(group);
		user.setGroupMissions(group.getGroupMissions());
		
		userRepository.save(user);
		userSaltRepository.save(new UserSaltEntity(user.getUserId(),encryptionResult.getSalt()));
	}

	public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) throws AuthenticationFailedException {
		UserEntity loginUser = userRepository.findByUserNickname(loginRequestDto.getUserNickname())
				.orElseThrow(() -> new ResourceNotFoundException("NICKNAME_NOT_FOUND"));

		String salt = userSaltRepository.findById(loginUser.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("SALT_NOT_FOUND")).getSalt();

		String encryptPassword = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(loginRequestDto.getUserPassword(), salt));
		if (!loginUser.getUserPassword().equals(encryptPassword)) {
			throw new AuthenticationFailedException("AUTH_FAILED");
		}

		return new LoginResponseDto(loginUser.getUserNickname(), loginUser.getUserId(),
				loginUser.getGroup().getGroupNo());
	}

	public void updateUserTargetCalorie(UUID userId, TargetCalorieRequestDto targetCalorieRequestDto) {
		UserEntity user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));

		user.updateTargetCalorie(targetCalorieRequestDto.getUserTargetcalorie());
	}
}
