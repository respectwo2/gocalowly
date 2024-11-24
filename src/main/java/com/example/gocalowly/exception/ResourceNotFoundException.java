package com.example.gocalowly.exception;

//데이터베이스에서 데이터를 못찾은 경우 발생하는 예외
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
