package com.example.gocalowly.domain.user.entity;

public class UserEntity {
	private int userNo; // 유저 식별 번호
	private String userPassword;
	private String userName;
	private String userPhoneNumber;
	private String userNickName; //실제 로그인 시 사용되는 아이디 unique
	private int completeCount; // 이번달 칼로리 지킨 날 수
}
