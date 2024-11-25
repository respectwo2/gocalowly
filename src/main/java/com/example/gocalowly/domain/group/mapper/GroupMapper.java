package com.example.gocalowly.domain.group.mapper;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    public GroupInfoResponseDto entityToDto(GroupEntity group) {
        return new GroupInfoResponseDto(
                group.getGroupName(),
                group.getHeadcount()
        );
    }
}
