package com.ncs.capstone.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class InvalidUsernameException extends Exception {
	
	private String errorMsg;
	private String username;
	private LocalDateTime date;
	
	public InvalidUsernameException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidUsernameException(String errorMsg, String username, LocalDateTime date) {
		super();
		this.errorMsg = errorMsg;
		this.username = username;
		this.date = date;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InvalidUsernameException [errorMsg=" + errorMsg + ", username=" + username + ", date=" + date + "]";
	}
	
	
	
}
