package com.example.gocalowly.domain.user.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.gocalowly.domain.food.entity.FoodLogEntity;
import com.example.gocalowly.domain.group.entity.GroupEntity;
import com.example.gocalowly.domain.groupmission.entity.UserGroupMissionEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)")
	private UUID userId;
	
	private String userPassword;
	private String userName;
	private String userPhonenumber;
	private String userNickname; //실제 로그인 시 사용되는 아이디 unique
	private int completeCount; // 이번달 칼로리 지킨 날 수
	private int userTargetcalorie;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_no")
	private GroupEntity group;
	
	@OneToMany(mappedBy = "user")
	private List<UserGroupMissionEntity> userGroupMissions = new ArrayList<>();

	public UserEntity(String userPassword, String userName, String userPhonenumber, String userNickname,
			int userTargetcalorie) {
		super();
		setUserPassword(userPassword);
		setUserName(userName);
		setUserPhonenumber(userPhonenumber);
		setUserNickname(userNickname);
		setUserTargetcalorie(userTargetcalorie);
	}

	public UUID getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPhonenumber() {
		return userPhonenumber;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public int getCompleteCount() {
		return completeCount;
	}

	public int getUserTargetcalorie() {
		return userTargetcalorie;
	}
	
    public void updateTargetCalorie(int newTargetCalorie) {
        if (newTargetCalorie <= 0) {
            // 여기서 예외 처리!!
        }
        this.userTargetcalorie = newTargetCalorie;
    }

	public void changePassword(String encryptedPassword) {
		this.userPassword = encryptedPassword;
	}

	
	
	private void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	private void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}

	private void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	private void setUserTargetcalorie(int userTargetcalorie) {
		this.userTargetcalorie = userTargetcalorie;
	}
	
	
	public void addUserGroupMission(UserGroupMissionEntity userGroupMissionEntity) {
		if (userGroupMissions.contains(userGroupMissionEntity)) {
			// 여기서 중복 처리!!
		}
		
		userGroupMissions.add(userGroupMissionEntity);
	}
	
	public List<UserGroupMissionEntity> getUserMissions() {
		return userGroupMissions;
	}
}
