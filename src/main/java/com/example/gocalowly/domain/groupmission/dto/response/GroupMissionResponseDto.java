package com.example.gocalowly.domain.groupmission.dto.response;

import java.util.List;

public class GroupMissionResponseDto {
	private List<Mission> missions;
	
	public static class Mission {
		private int missionId;
		private String missionName;
		private boolean isMissionComplete;
	}
}
