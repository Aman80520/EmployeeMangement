package com.example.emp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourseNotFound(ResourseNotFoundException e){
		ErrorResponse erp=new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
		return new ResponseEntity<>(erp,HttpStatus.NOT_FOUND);
	}

}
