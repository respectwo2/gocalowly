package com.example.gocalowly.domain.group.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.group.mapper.GroupMapper;
import com.example.gocalowly.domain.group.repository.GroupRepository;
import com.example.gocalowly.exception.ResourceNotFoundException;

@Service
public class GroupService {
	GroupMapper groupMapper;
	GroupRepository groupRepository;

	public GroupService(GroupMapper groupMapper, GroupRepository groupRepository) {
		this.groupMapper = groupMapper;
		this.groupRepository = groupRepository;
	}

	public GroupInfoResponseDto getGroupInfo(int groupNo) {
		GroupEntity group = groupRepository.findById(groupNo)
					.orElseThrow(() -> new ResourceNotFoundException("GROUP_NOT_FOUND"));

		return groupMapper.entityToDto(group);
	}

	@Transactional
	public void changeGroupName(int testGroupNo, String newGroupName) {
		// 원래는 모든 그룹에 대해 실행해야 하므로 groupRepository.findAll().stream().... 을 이용해서 바꿔야 하지만 지금은 하나만
		
		GroupEntity group = groupRepository.findById(testGroupNo)
				.orElseThrow(() -> new ResourceNotFoundException("GROUP_NOT_FOUND"));
		
		group.setGroupName(newGroupName);
	}
}
