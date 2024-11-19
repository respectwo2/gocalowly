package com.example.gocalowly.domain.chat.mapper;

import org.springframework.stereotype.Component;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.entity.ChatEntity;
@Component
public class ChatMapper {

	public ChatEntity dtoToEntity(ChatSubmitRequestDto request,String userNickname,int groupNo) {

		return new ChatEntity(userNickname,request.getContent(),groupNo);

	}

}
