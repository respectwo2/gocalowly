package com.example.gocalowly.domain.groupmission.dto.request;

import java.util.List;

public class GroupMissionSubmitRequestDto {
	private int userNo;
	private List<MissionComplete> missionCompletes;
	
	public static class MissionComplete {
		private int missonId;
		private boolean isMissionComplete;
	}
}
