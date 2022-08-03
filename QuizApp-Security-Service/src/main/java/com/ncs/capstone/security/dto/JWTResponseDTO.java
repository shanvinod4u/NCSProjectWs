package com.ncs.capstone.security.dto;

import org.springframework.stereotype.Component;

@Component
public class JWTResponseDTO {

	private String token;
	private String username;
	private String role;
	private int userId;
	private boolean isValid;

	public JWTResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JWTResponseDTO(String token, String username, boolean isValid, String role, int userId) {
		super();
		this.token = token;
		this.role = role;
		this.username = username;
		this.isValid = isValid;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "JWTResponseDTO [token=" + token + ", username=" + username + ", role=" + role + ", userId=" + userId
				+ ", isValid=" + isValid + "]";
	}
	
	
}
