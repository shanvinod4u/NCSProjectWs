package com.ncs.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.capstone.exception.InvalidEmailException;
import com.ncs.capstone.exception.InvalidUsernameException;
import com.ncs.capstone.model.User;


public interface UserService {
	
	public User addUser(User u)throws InvalidUsernameException, InvalidEmailException;
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User updateUser(User u);
	public boolean deleteUserById(int id);
	
}
