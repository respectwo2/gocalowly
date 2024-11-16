package com.example.gocalowly.domain.group.dto.request;

import java.util.UUID;

// 그룹 상단 배너의 상위 몇%인지 요청하는 RequestDto 
public class GroupRankRequestDto {
	private int groupNo; // 그룹 No
	private UUID userId; // 유저 No
	
	public GroupRankRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupRankRequestDto(int groupNo, UUID userId) {
		super();
		this.groupNo = groupNo;
		this.userId = userId;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public UUID getUserId() {
		return userId;
	}
	
	
}
