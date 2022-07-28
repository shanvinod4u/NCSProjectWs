package com.ncs.capstone.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class InvalidEmailException extends Exception {
	private String errorMsg;
	private String email;
	private LocalDateTime date;
	
	public InvalidEmailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidEmailException(String errorMsg, String email, LocalDateTime date) {
		super();
		this.errorMsg = errorMsg;
		this.email = email;
		this.date = date;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InvalidEmailException [errorMsg=" + errorMsg + ", email=" + email + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
}
