package com.ncs.capstone.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {
	
	public AllExceptionHandler() {
		
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidUsernameExceptionData(InvalidUsernameException e)
	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMsg());
		template.setUserInput(e.getUsername());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidEmailExceptionData(InvalidEmailException e)
	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMsg());
		template.setUserInput(e.getEmail());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleInvalidQuestionExceptionData(InvalidQuestionException e)
	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getErrorMsg());
		template.setUserInput(e.getQuestion());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
}
