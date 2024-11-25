package com.example.gocalowly.domain.group.controller;


import com.example.gocalowly.domain.group.service.GroupService;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
    private final OpenAiChatModel openAiChatModel;
    private final GroupService groupService;

    private static final String REQUEST_TO_GPT = "식단 관리 그룹 참가자들이 모인 한글 그룹 이름 하나 추천해줘. "
            + "그룹 이름은 사용자에게 말하는 듯한 그룹 이름으로 해주고, 딱딱하지 않고 캐쥬얼한 단어를 썼으면 좋겠어. "
            + "글자 수는 한글 기준으로 25자 이상이어야 해. "
            + "다른 미사여구, 쌍따옴표 없이 딱 그룹 이름만 답변해줬으면 좋겠어.";

    public AIController(OpenAiChatModel openAiChatModel, GroupService groupService) {
        this.openAiChatModel = openAiChatModel;
        this.groupService = groupService;
    }

    @PostMapping("/chatGPT")
    public ResponseEntity<String> changeGroupName() {
        int testGroupNo = 1;

        String response = openAiChatModel.call(REQUEST_TO_GPT);
        groupService.changeGroupName(testGroupNo, response);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


}
