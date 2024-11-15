package com.example.gocalowly.domain.group.dto.request;

// 그룹 상단 배너의 상위 몇%인지 요청하는 RequestDto 
public class GroupRankRequestDto {
	private int groupId; // 그룹 ID
	private int userNo; // 유저 No
	
	public GroupRankRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupRankRequestDto(int groupId, int userNo) {
		super();
		this.groupId = groupId;
		this.userNo = userNo;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getUserNo() {
		return userNo;
	}
	
	
}
