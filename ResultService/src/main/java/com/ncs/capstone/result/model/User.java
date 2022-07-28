package com.ncs.capstone.result.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable, Comparable<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private String email;
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userInfo")
	@JsonBackReference
	private Set<TestScore> allTestScore;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	


	public Set<TestScore> getAllTestScore() {
		return allTestScore;
	}

	public void setAllTestScore(Set<TestScore> allTestScore) {
		this.allTestScore = allTestScore;
	}


	@Override
	public int hashCode() {
		return Objects.hash(allTestScore, email, password, role, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(allTestScore, other.allTestScore) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& userId == other.userId && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", allTestScore=" + allTestScore + "]";
	}

	@Override
	public int compareTo(User u) {
		return this.userId - u.userId;
	}
		
	
}
