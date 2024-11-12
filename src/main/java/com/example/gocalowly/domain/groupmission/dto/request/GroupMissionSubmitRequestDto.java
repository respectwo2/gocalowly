package com.example.gocalowly.domain.groupmission.dto.request;

import java.util.List;

// 미션 달성 여부 업데이트를 요청하는 RequestDto 입니다. 
public class GroupMissionSubmitRequestDto {
	private int userNo; // 유저 No
	private List<MissionComplete> missionCompletes; // 미션 별 달성 여부 리스트 입니다.
	
	public static class MissionComplete { // 미션 달성 여부 클래스를 내부에서 선언한 클래스입니다.
		private int missonId; // 미션 ID
		private boolean isMissionComplete; // 미션 달성 여부
	}
}
