package com.ncs.capstone.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class InvalidQuestionException extends Exception {
	
	private String errorMsg;
	private String question;
	private LocalDateTime date;
	
	public InvalidQuestionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidQuestionException(String errorMsg, String question, LocalDateTime date) {
		super();
		this.errorMsg = errorMsg;
		this.question = question;
		this.date = date;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InvalidQuestionException [errorMsg=" + errorMsg + ", question=" + question + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
}
