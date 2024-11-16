package com.example.gocalowly.domain.chat.mapper;

import com.example.gocalowly.domain.chat.dto.request.ChatSubmitRequestDto;
import com.example.gocalowly.domain.chat.entity.ChatEntity;

public class ChatMapper {
	
	public ChatEntity dtoToEntity(ChatSubmitRequestDto request) {
		
		return new ChatEntity(
				request.getuserNickName(),
				request.getContent(),
				request.getGroupNo()
				);
		
	}

}
