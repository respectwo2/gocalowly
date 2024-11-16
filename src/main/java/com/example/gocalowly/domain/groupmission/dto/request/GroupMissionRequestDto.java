package com.example.gocalowly.domain.groupmission.dto.request;

import java.util.UUID;

// 그룹 미션 내역을 요청하는 RequestDto 입니다.
public class GroupMissionRequestDto {
	private int groupId; // 그룹 ID
	private UUID userId; // 유저 No
	
	public GroupMissionRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupMissionRequestDto(int groupId, UUID userId) {
		super();
		this.groupId = groupId;
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public UUID getUserId() {
		return userId;
	}
	
	
	
}
