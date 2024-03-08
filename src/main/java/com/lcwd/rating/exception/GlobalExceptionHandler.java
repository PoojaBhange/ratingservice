package com.lcwd.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.rating.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFound(Exception ex){
		String m = ex.getMessage();
		return new ResponseEntity<>(ApiResponse.builder().message(m).success(true).status(HttpStatus.NOT_FOUND).build(),HttpStatus.NOT_FOUND);
	}
}
