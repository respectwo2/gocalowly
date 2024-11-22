package com.example.gocalowly.domain.group.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.dto.response.GroupRankResponseDto;
import com.example.gocalowly.domain.group.service.GroupService;
import com.example.gocalowly.domain.user.service.UserGoalService;

@RestController
@RequestMapping("api/group")
public class GroupController {

	private static final UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");
	private static final int TEST_GROUPNO = 5;
	GroupService groupService;
	UserGoalService userGoalService;

	public GroupController(GroupService groupService, UserGoalService userGoalService) {
		this.groupService = groupService;
		this.userGoalService = userGoalService;
	}

	@GetMapping("/")
	public ResponseEntity<GroupInfoResponseDto> getGroupInfo() {

		try {
			GroupInfoResponseDto response = groupService.getGroupInfo(TEST_GROUPNO);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/rank")

	public ResponseEntity<GroupRankResponseDto> getRankInGroup() {
		try {
			GroupRankResponseDto response = userGoalService.getRankInGroup(TEST_USERID);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/testUpdate")
	public void updateGroupUserGoals() {
		userGoalService.addAllUserGoals();
	}

	@GetMapping("/testReset")
	public void resetGroupUserGoals() {
		userGoalService.resetUserClearGoals();
	}
}
