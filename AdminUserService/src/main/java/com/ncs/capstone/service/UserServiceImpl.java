package com.ncs.capstone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.capstone.exception.InvalidEmailException;
import com.ncs.capstone.exception.InvalidUsernameException;
import com.ncs.capstone.model.User;
import com.ncs.capstone.repository.UserRepository;
import com.ncs.capstone.util.ValidateUser;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ValidateUser validateUser;

	@Override
	public User addUser(User u) throws InvalidUsernameException, InvalidEmailException {
		
		if(u != null) {
			boolean status = validateUser.validateUsername(u);
			boolean emailStatus = validateUser.validateEmail(u);
			if(status == false) {
				throw new InvalidUsernameException("Username Already Exist!",u.getUsername(), LocalDateTime.now());
			}else if(emailStatus == false){
				throw new InvalidEmailException("Email Already Exist!",u.getEmail(), LocalDateTime.now());
			}
			else {
				User savedUser = userRepository.save(u);
				return savedUser;
			}
		}else {
			throw new NullPointerException("User Info Is Null");
		}
		
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User getUserById(int id) {
		
		User user = userRepository.getById(id);
		return user;
	}

	@Override
	public User updateUserRole(String role, int id) {
		
		boolean status = userRepository.updateUserRole(role, id);
		if(status == true) {
			User user = userRepository.getById(id);
			return user;
		}
		return null;
	}

	@Override
	public boolean deleteUserById(int id) {
		
		userRepository.deleteById(id);
		return true;
	}

}
