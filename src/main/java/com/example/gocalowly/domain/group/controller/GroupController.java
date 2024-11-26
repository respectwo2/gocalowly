package com.example.gocalowly.domain.group.controller;

import com.example.gocalowly.domain.group.dto.response.GroupInfoResponseDto;
import com.example.gocalowly.domain.group.dto.response.GroupRankResponseDto;
import com.example.gocalowly.domain.group.service.GroupService;
import com.example.gocalowly.domain.user.service.UserGoalService;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    public ResponseEntity<GroupInfoResponseDto> getGroupInfo(@SessionAttribute int groupNo) {

        GroupInfoResponseDto response = groupService.getGroupInfo(groupNo);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/rank")
    public ResponseEntity<GroupRankResponseDto> getRankInGroup(@SessionAttribute UUID userId) {
        GroupRankResponseDto response = userGoalService.getRankInGroup(userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
