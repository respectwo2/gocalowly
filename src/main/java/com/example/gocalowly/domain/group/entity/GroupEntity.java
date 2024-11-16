package com.example.gocalowly.domain.group.entity;

public class GroupEntity {
	private int groupNo;
	private int calorieGoal;
	private int headcount;
	private String groupName;
	
	public GroupEntity() {
		// TODO Auto-generated constructor stub
	}
	public GroupEntity(int calorieGoal, int headcount, String groupName) {
		super();
		this.calorieGoal = calorieGoal;
		this.headcount = headcount;
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
