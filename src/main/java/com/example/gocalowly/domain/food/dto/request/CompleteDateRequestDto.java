package com.example.gocalowly.domain.food.dto.request;

import java.util.Date;

//userNo와 날짜를 통해 성공여부를 반환하는 DTO
public class CompleteDateRequestDto {
	private int userNo;
	private Date recodeDate; 
	//foodlog 테이블의 조인을 통해 sum 집계함수를 통해 성공 여부를 반환해야함
}
