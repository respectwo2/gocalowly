package com.example.gocalowly.domain.user.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user_salt")
public class UserSaltEntity {
	@Id
	@Column(columnDefinition = "BINARY(16)")
	private UUID userId;
	private String salt;
	
	public UserSaltEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserSaltEntity(UUID userId, String salt) {
		super();
		this.userId = userId;
		this.salt = salt;
	}

	
	
	
}
