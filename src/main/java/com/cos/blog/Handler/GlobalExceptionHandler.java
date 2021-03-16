package com.cos.blog.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;

//모든 오류가 이쪽으로 오게 된다.
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	//IllegalArgumentException에 대한 처리
	@ExceptionHandler(value=Exception.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		System.out.println("Global Exception Handler!!!!!!");
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
//		return "<h1>"+e.getMessage()+"</h1>";
	}
	
}
