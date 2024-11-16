package com.example.gocalowly.domain.group.dto.request;

// 그룹 상단 배너에 그룹 이름과 그룹 인원을 불러오는 RequestDto입니다.
public class GroupInfoRequestDto {
	private int groupNo; // 그룹 No
	
	public GroupInfoRequestDto() {
		// TODO Auto-generated constructor stub
	}
	public GroupInfoRequestDto(int groupNo) {
		super();
		this.groupNo = groupNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	
}
