package com.example.gocalowly.domain.groupmission.controller;

import com.example.gocalowly.domain.groupmission.dto.request.GroupMissionUpdateRequestDto;
import com.example.gocalowly.domain.groupmission.dto.response.GroupMissionResponseDto;
import com.example.gocalowly.domain.groupmission.service.GroupMissionSerivce;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("api/group/missions")
public class GroupMissionController {
    GroupMissionSerivce groupMissionService;

    public GroupMissionController(GroupMissionSerivce groupMissionService) {
        this.groupMissionService = groupMissionService;
    }

    @GetMapping("/")
    public ResponseEntity<GroupMissionResponseDto> getGroupMissions(@SessionAttribute UUID userId) {
        GroupMissionResponseDto response = groupMissionService.getGroupMissions(userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateGroupMissions(
            @RequestBody GroupMissionUpdateRequestDto groupMissionUpdateRequestDto, @SessionAttribute UUID userId) {
        groupMissionService.updateGroupMissions(groupMissionUpdateRequestDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
