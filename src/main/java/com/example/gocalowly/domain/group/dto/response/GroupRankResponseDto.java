package com.example.gocalowly.domain.group.dto.response;

// 그룹 상단 배너의 상위 몇%인지 정보를 전달하는 ResponseDto
public class GroupRankResponseDto {
	private int topPercentile; // 상위 몇%
	
	public GroupRankResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public GroupRankResponseDto(int topPercentile) {
		super();
		this.topPercentile = topPercentile;
	}

	public int getTopPercentile() {
		return topPercentile;
	}
	
}
