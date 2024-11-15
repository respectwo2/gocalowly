package com.example.gocalowly.domain.group.dto.request;

// 그룹 상단 배너에 그룹 이름과 그룹 인원을 불러오는 RequestDto입니다.
public class GroupInfoRequestDto {
	private int groupId; // 그룹 ID
	
	public GroupInfoRequestDto() {
		// TODO Auto-generated constructor stub
	}
	public GroupInfoRequestDto(int groupId) {
		super();
		this.groupId = groupId;
	}
	public int getGroupId() {
		return groupId;
	}
	
}
