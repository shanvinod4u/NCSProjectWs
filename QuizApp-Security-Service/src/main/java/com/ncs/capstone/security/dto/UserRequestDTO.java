package com.ncs.capstone.security.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequestDTO {
	
	private String username;
	private String password;
	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRequestDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AppUserRequestDTO [username=" + username + ", password=" + password + "]";
	}
	
	

}
