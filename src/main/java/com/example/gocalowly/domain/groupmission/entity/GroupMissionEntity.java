package com.example.gocalowly.domain.groupmission.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.gocalowly.domain.group.entity.GroupEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "group_mission")
public class GroupMissionEntity {
	@Id
	private int missionNo;
	private String missionName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_no")
	private GroupEntity group;
	
	@OneToMany(mappedBy = "groupMission")
	private List<UserGroupMissionEntity> userGroupMissions = new ArrayList<>();
	
	public GroupMissionEntity() {
		// TODO Auto-generated constructor stub
	}

	public GroupMissionEntity(int missionNo, String missionName) {
		super();
		setMissionNo(missionNo);
		setMissionName(missionName);
	}
	
	private void setMissionNo(int missionNo) {
		this.missionNo = missionNo;
	}

	private void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public int getMissionNo() {
		return missionNo;
	}

	public String getMissionName() {
		return missionName;
	}
	
	public GroupEntity getGroup() {
		return group;
	}
	
	public void addUserGroupMission(UserGroupMissionEntity userGroupMissionEntity) {
		if (userGroupMissions.contains(userGroupMissionEntity)) {
			//중복 에러 체크!!
			return;
		}
		userGroupMissions.add(userGroupMissionEntity);
	}
	
	public List<UserGroupMissionEntity> getUserGroupMissions() {
		return userGroupMissions;
	}
}
