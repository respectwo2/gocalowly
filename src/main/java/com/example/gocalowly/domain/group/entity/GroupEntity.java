package com.example.gocalowly.domain.group.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.gocalowly.domain.groupmission.entity.GroupMissionEntity;
import com.example.gocalowly.domain.groupmission.entity.UserGroupMissionEntity;
import com.example.gocalowly.domain.user.entity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="`group`")
public class GroupEntity {
	@Id
	private int groupNo;
	private int calorieGoal;
	private int headcount;
	private String groupName;
	
	@OneToMany(mappedBy = "group")
	private List<GroupMissionEntity> groupMissions = new ArrayList<>();
	
	@OneToMany(mappedBy= "group")
	private List<UserEntity> users = new ArrayList<>();
	
	public GroupEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public GroupEntity(int calorieGoal, int headcount, String groupName) {
		super();
		setCalorieGoal(calorieGoal);
		setHeadcount(headcount);
		setGroupName(groupName);
	}
	
	private void setCalorieGoal(int calorieGoal) {
		this.calorieGoal = calorieGoal;
	}
	private void setHeadcount(int headcount) {
		this.headcount = headcount;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public int getCalorieGoal() {
		return calorieGoal;
	}
	public int getHeadcount() {
		return headcount;
	}
	public String getGroupName() {
		return groupName;
	}
	
	public List<GroupMissionEntity> getGroupMissions() {
		return groupMissions;
	}
	
	public List<UserEntity> getUsers() {
		return users;
	}
	
	public void addUser(UserEntity user) {
		if (users.contains(user)) {
			//중복 에러 체크!!
			return;
		}
		users.add(user);
		headcount += 1;
	}
	
	public void deleteUser(UserEntity user) {
		if (users.remove(user)) {
			headcount -= 1;
		}
	}
}
