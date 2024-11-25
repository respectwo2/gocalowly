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

@RestController
@RequestMapping("api/group/missions")
public class GroupMissionController {

    private static final UUID TEST_USERID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    GroupMissionSerivce groupMissionService;

    public GroupMissionController(GroupMissionSerivce groupMissionService) {
        this.groupMissionService = groupMissionService;
    }

    @GetMapping("/")
    public ResponseEntity<GroupMissionResponseDto> getGroupMissions() {
        GroupMissionResponseDto response = groupMissionService.getGroupMissions(TEST_USERID);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateGroupMissions(
            @RequestBody GroupMissionUpdateRequestDto groupMissionUpdateRequestDto) {
        groupMissionService.updateGroupMissions(groupMissionUpdateRequestDto, TEST_USERID);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
