package com.example.gocalowly.exception;

//로그인 실패 및 인증 관련 예외
//실제로는 spring security의 동일한 이름의 예외를 상속받아서 사용하는편이 좋음
public class AuthenticationFailedException extends Exception {
	public AuthenticationFailedException(String message) {
		super(message);
	}

}
