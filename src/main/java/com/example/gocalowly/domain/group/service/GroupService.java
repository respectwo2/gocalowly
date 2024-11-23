package com.example.gocalowly.domain.group.service;

import org.springframework.stereotype.Service;

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
					.orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));

		return groupMapper.entityToDto(group);
	}
}
