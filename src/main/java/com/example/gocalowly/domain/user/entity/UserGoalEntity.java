package com.example.gocalowly.domain.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_goal")
public class UserGoalEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_goal_no")
	private int userGoalNo;
	private LocalDateTime userGoalDate;
	private boolean isGoalComplete;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	UserEntity user;
	
	public UserGoalEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserGoalEntity(LocalDateTime userGoalDate, boolean isGoalComplete) {
		super();
		this.userGoalDate = userGoalDate;
		this.isGoalComplete = isGoalComplete;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getUserGoalNo() {
		return userGoalNo;
	}

	public LocalDateTime getUserGoalDate() {
		return userGoalDate;
	}

	public boolean isGoalComplete() {
		return isGoalComplete;
	}
}
