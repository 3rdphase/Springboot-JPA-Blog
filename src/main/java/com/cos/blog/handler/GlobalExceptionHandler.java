package com.cos.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;

@ControllerAdvice	//Exception 발생시 이쪽으로 전달
@RestController
public class GlobalExceptionHandler {

	//특정 Exception
	/*
	 * @ExceptionHandler(value=IllegalArgumentException.class) public String
	 * handleArqumentException(IllegalArgumentException e) { return "<h1>" +
	 * e.getMessage() + "</h1>"; }
	 */
	
	//모든 Exception
	@ExceptionHandler(value=Exception.class)
	public ResponseDto<String> handleArqumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}	
}
