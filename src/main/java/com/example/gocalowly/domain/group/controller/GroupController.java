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

        GroupInfoResponseDto response = groupService.getGroupInfo(TEST_GROUPNO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/rank")

    public ResponseEntity<GroupRankResponseDto> getRankInGroup() {
        GroupRankResponseDto response = userGoalService.getRankInGroup(TEST_USERID);

        return ResponseEntity.status(HttpStatus.OK).body(response);
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
