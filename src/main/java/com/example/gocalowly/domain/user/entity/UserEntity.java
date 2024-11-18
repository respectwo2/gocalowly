package com.example.gocalowly.domain.user.entity;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public UserEntity(String userPassword, String userName, String userPhonenumber, String userNickname,
			int userTargetcalorie) {
		super();
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhonenumber = userPhonenumber;
		this.userNickname = userNickname;
		this.userTargetcalorie = userTargetcalorie;
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
	
}
