package com.example.gocalowly.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//전역 예외 처리기
@RestControllerAdvice
public class GlobalExceptionHandler {
	//유효성 검사
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                           .stream()
                           .findFirst()
                           .map(error -> error.getDefaultMessage())
                           //아예 이상한 값
                           .orElse("Invalid input");

        ErrorResponse errorResponse = new ErrorResponse("VALIDATION_ERROR", message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
//    //데이터를 찾을 수 없는 오류
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementException ex) {
//        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
    
    //인증 실패 예외 처리
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationFailedException(AuthenticationFailedException ex) {
    	ErrorResponse errorResponse = new ErrorResponse("AUTH_FAILED",ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
    
    //데이터를 찾을 수 없는 오류
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlResourceNotFoundException(ResourceNotFoundException ex) {
    	ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND",ex.getMessage());
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
