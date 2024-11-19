package com.example.gocalowly.domain.groupmission.dto.response;

import java.util.List;

// 그룹 미션 내역을 전달하는 ResponseDto 입니다.
public class GroupMissionResponseDto {
	private List<Mission> missions; // 미션 리스트를 전달합니다.
	
	public static class Mission { // 미션 클래스를 내부에서 선언합니다.
		private int missionId; // 미션 ID
		private String missionName; // 미션 이름
		private boolean isMissionComplete; // 미션 달성 여부
		
	}
}
