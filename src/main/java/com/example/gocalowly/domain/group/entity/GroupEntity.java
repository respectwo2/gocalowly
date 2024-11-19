package com.example.gocalowly.domain.group.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="`group`")
public class GroupEntity {
	@Id
	private int groupNo;
	private int calorieGoal;
	private int headcount;
	private String groupName;
	
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
	private void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getgroupNo() {
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
	
	
}
