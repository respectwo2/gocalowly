package com.example.gocalowly.domain.groupmission.entity;

public class GroupMissionEntity {
	private int missionId;
	private String missionName;
	private int groupId;
	
	public GroupMissionEntity() {
		// TODO Auto-generated constructor stub
	}

	public GroupMissionEntity(int missionId, String missionName, int groupId) {
		super();
		this.missionId = missionId;
		this.missionName = missionName;
		this.groupId = groupId;
	}

	public int getMissionId() {
		return missionId;
	}

	public String getMissionName() {
		return missionName;
	}

	public int getGroupId() {
		return groupId;
	}
	
	
}
