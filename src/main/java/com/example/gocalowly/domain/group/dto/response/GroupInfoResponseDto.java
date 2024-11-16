package com.example.gocalowly.domain.group.dto.response;

// 그룹 상단 배너의 그룹 이름과 그룹 인원을 전달하는 ResponseDto 입니다.
public class GroupInfoResponseDto {
	private String groupName; // 그룹 이름
	private int headcount; // 그룹 인원
	
	public GroupInfoResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupInfoResponseDto(String groupName, int headcount) {
		super();
		this.groupName = groupName;
		this.headcount = headcount;
	}

	public String getGroupName() {
		return groupName;
	}

	public int getHeadcount() {
		return headcount;
	}
	
}
