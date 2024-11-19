package com.example.gocalowly.domain.groupmission.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.hibernate.sql.exec.ExecutionException;
import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.group.repository.GroupRepository;
import com.example.gocalowly.domain.groupmission.dto.request.GroupMissionUpdateRequestDto;
import com.example.gocalowly.domain.groupmission.dto.request.GroupMissionUpdateRequestDto.MissionComplete;
import com.example.gocalowly.domain.groupmission.dto.response.GroupMissionResponseDto;
import com.example.gocalowly.domain.groupmission.entity.UserGroupMissionEntity;
import com.example.gocalowly.domain.groupmission.repository.GroupMissionRepository;
import com.example.gocalowly.domain.user.entity.UserEntity;
import com.example.gocalowly.domain.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupMissionSerivce {
	UserRepository userRepository;
	GroupMissionRepository groupMissionRepository;
	
	public GroupMissionSerivce(UserRepository userRepository, GroupMissionRepository groupMissionRepository) {
		this.userRepository = userRepository;
		this.groupMissionRepository = groupMissionRepository;
	}
	
	public GroupMissionResponseDto getGroupMissions(UUID userId) {
		List<UserGroupMissionEntity> userMissions = userRepository.findByIdWithMissions(userId)
				.orElseThrow(() -> new NoSuchElementException("일치하는 유저가 없습니다."))
				.getUserMissions();
		
		return new GroupMissionResponseDto(userMissions.stream()
				.map(userGroupMissionEntity -> new GroupMissionResponseDto.Mission(
						userGroupMissionEntity.getGroupMission().getMissionNo(),
						userGroupMissionEntity.getGroupMission().getMissionName(), 
						userGroupMissionEntity.isMissionComplete()))
				.toList());
	}
	
	public void updateGroupMissions(GroupMissionUpdateRequestDto groupMissionUpdateRequestDto, UUID userId) {
		List<UserGroupMissionEntity> userMissions = userRepository.findByIdWithMissions(userId)
				.orElseThrow(() -> new NoSuchElementException("일치하는 유저가 없습니다."))
				.getUserMissions();
		
		userMissions.forEach(userGroupMission -> updateGroupMission(userGroupMission, groupMissionUpdateRequestDto.getMissionCompletes()));
	}

	private void updateGroupMission(UserGroupMissionEntity userGroupMission, List<MissionComplete> missionCompletes) {
		for (MissionComplete missionComplete :missionCompletes) {
			if (missionComplete.getMissionNo() == userGroupMission.getGroupMission().getMissionNo()) {
				userGroupMission.setMissionComplete(missionComplete.isMissionComplete());
			}
		}
	}
	
}
