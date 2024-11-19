package com.example.gocalowly.domain.group.mapper;

import org.springframework.stereotype.Component;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.entity.GroupEntity;

@Component
public class GroupMapper {
	
	public GroupInfoResponseDto entityToDto(GroupEntity group) {
		return new GroupInfoResponseDto(
				group.getGroupName(),
				group.getHeadcount()
				);
	}
}
