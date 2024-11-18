package com.example.gocalowly.domain.groupmission.entity;

public class GroupMissionEntity {
	private int missionId;
	private String missionName;
	private int groupId;
	
	public GroupMissionEntity() {
		// TODO Auto-generated constructor stub
	}

	public GroupMissionEntity(int missionId, String missionName) {
		super();
		setMissionId(missionId);
		setMissionName(missionName);
	}
	

	private void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	private void setMissionName(String missionName) {
		this.missionName = missionName;
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
