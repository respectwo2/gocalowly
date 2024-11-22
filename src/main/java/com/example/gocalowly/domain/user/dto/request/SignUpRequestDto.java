package com.example.gocalowly.domain.user.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// 회원가입때 사용되는 DTO
public class SignUpRequestDto {
    @NotBlank(message = "닉네임을 입력해주세요")
    private String userNickname; // 유저 닉네임
    
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String userPassword; // 유저 비밀번호
    
    @NotBlank(message = "유저 이름을 입력해주세요")
    private String userName; // 유저 이름

    @Pattern(regexp = "\\d{10,11}", message = "휴대폰 번호는 10~11자리 숫자여야 해요")
    @NotBlank(message = "휴대폰 번호를 입력해주세요")
    private String userPhonenumber; // 유저 번호
    
    @Min(value = 1000, message = "목표 칼로리는 1000 이상이어야 해요")
    @Max(value = 9999, message = "목표 칼로리는 9999 이하여야 해요")
    private int userTargetcalorie; // 목표 칼로리

    public SignUpRequestDto() {
        // 기본 생성자
    }

    public SignUpRequestDto(String userNickname, String userPassword, String userName, String userPhonenumber,
            int userTargetcalorie) {
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhonenumber = userPhonenumber;
        this.userTargetcalorie = userTargetcalorie;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public int getUserTargetcalorie() {
        return userTargetcalorie;
    }
}
