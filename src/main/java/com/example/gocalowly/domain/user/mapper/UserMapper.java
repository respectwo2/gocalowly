package com.example.gocalowly.domain.user.mapper;

import com.example.gocalowly.domain.user.dto.request.SignUpRequestDto;
import com.example.gocalowly.domain.user.dto.response.LoginResponseDto;
import com.example.gocalowly.domain.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // 회원가입으로 유저 객체 생성
    public UserEntity dtoToEntity(SignUpRequestDto request) {
        return new UserEntity(request.getUserPassword(),
                request.getUserName(),
                request.getUserPhonenumber(),
                request.getUserNickname(),
                request.getUserTargetcalorie()
        );
    }

    // 유저로 로그인 객체 생성
    public LoginResponseDto entityToDto(UserEntity user, int groupNo) {
        return new LoginResponseDto(
                user.getUserNickname(),
                user.getUserId(),
                groupNo
        );
    }

}
