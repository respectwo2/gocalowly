package com.example.gocalowly.domain.group.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.service.GroupService;

@RestController
@RequestMapping("api/group")
public class GroupController {
	GroupService groupService;
	
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping("/")
	public ResponseEntity<GroupInfoResponseDto> getGroupInfo() {
		int testGroupNo = 5;
		
		return ResponseEntity.ok(groupService.getGroupInfo(testGroupNo));
	}
}
