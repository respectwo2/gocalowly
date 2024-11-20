package com.example.gocalowly.domain.groupmission.entity;

import java.util.UUID;

import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.user.entity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_group_mission")
public class UserGroupMissionEntity {
	private boolean isMissionComplete = false;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mission_no")
	private GroupMissionEntity groupMission;

	public UserGroupMissionEntity() {
		// TODO Auto-generated constructor stub
	}

	public boolean isMissionComplete() {
		return isMissionComplete;
	}

	public void setMissionComplete(boolean isMissionComplete) {
		this.isMissionComplete = isMissionComplete;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public GroupMissionEntity getGroupMission() {
		return groupMission;
	}

	public void setGroupMission(GroupMissionEntity groupMission) {
		this.groupMission = groupMission;
	}
}
