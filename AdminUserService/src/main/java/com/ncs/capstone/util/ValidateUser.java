package com.ncs.capstone.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.capstone.model.User;
import com.ncs.capstone.repository.UserRepository;
import com.ncs.capstone.service.UserService;

@Component
public class ValidateUser {
	
	@Autowired
	UserRepository userRepository;
	
	public boolean validateUsername(User u) {
		
		String username = u.getUsername();
		User existingUser = userRepository.getUserByUsername(username);
		
		if(existingUser != null) {
				return false;
		}else {
			return true;
		}
	}
	
	public boolean validateEmail(User u) {
		String email = u.getEmail();
		User existingUser = userRepository.getUserByEmail(email);
		if(existingUser != null) {
			return false;
		}else {
			return true;
		}	
	}
	
}
