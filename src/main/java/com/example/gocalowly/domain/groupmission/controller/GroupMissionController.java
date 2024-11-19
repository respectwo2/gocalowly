package com.example.gocalowly.domain.groupmission.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gocalowly.domain.groupmission.dto.request.GroupMissionUpdateRequestDto;
import com.example.gocalowly.domain.groupmission.dto.response.GroupMissionResponseDto;
import com.example.gocalowly.domain.groupmission.service.GroupMissionSerivce;

@RestController
@RequestMapping("api/group/missions")
public class GroupMissionController {
	GroupMissionSerivce groupMissionService;
	
	public GroupMissionController(GroupMissionSerivce groupMissionService) {
		this.groupMissionService = groupMissionService;
	}
	
	@GetMapping("/")
	public ResponseEntity<GroupMissionResponseDto> getGroupMissions() {
		UUID testUserUUID= UUID.fromString("00000000-0000-0000-0000-000000000001");
		
		return ResponseEntity.ok(groupMissionService.getGroupMissions(testUserUUID));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateGroupMissions(@RequestBody GroupMissionUpdateRequestDto groupMissionUpdateRequestDto) {
		UUID testUserUUID= UUID.fromString("00000000-0000-0000-0000-000000000001");
		
		try {
			groupMissionService.updateGroupMissions(groupMissionUpdateRequestDto, testUserUUID);
			return ResponseEntity.ok("");
		}catch(NoSuchElementException e) {
			return ResponseEntity.badRequest().body("");
		}
	}
}