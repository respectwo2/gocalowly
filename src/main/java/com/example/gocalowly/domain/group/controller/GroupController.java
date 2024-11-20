package com.example.gocalowly.domain.group.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.service.GroupService;
import com.example.gocalowly.domain.user.service.UserGoalService;

@RestController
@RequestMapping("api/group")
public class GroupController {
	GroupService groupService;
	UserGoalService userGoalService;
	
	public GroupController(GroupService groupService, UserGoalService userGoalService) {
		this.groupService = groupService;
		this.userGoalService = userGoalService;
	}
	
	@GetMapping("/")
	public ResponseEntity<GroupInfoResponseDto> getGroupInfo() {
		int testGroupNo = 5;
		
		return ResponseEntity.ok(groupService.getGroupInfo(testGroupNo));
	}
	
	@GetMapping("/rank")
	public ResponseEntity<Integer> getRankInGroup() {
		UUID testUserId  = UUID.fromString("00000000-0000-0000-0000-000000000002");
		
		return ResponseEntity.ok(userGoalService.getRankInGroup(testUserId));
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
