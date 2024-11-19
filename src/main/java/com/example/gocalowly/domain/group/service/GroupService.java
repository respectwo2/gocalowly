package com.example.gocalowly.domain.group.service;

import org.springframework.stereotype.Service;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.group.mapper.GroupMapper;
import com.example.gocalowly.domain.group.repository.GroupRepository;

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
				.orElse(null // 여기서 예외처리
						);
		
		return groupMapper.entityToDto(group);
	}
}
