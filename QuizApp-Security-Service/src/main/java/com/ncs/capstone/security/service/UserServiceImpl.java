package com.ncs.capstone.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.ncs.capstone.security.model.MyUserDetails;
import com.ncs.capstone.security.model.User;
import com.ncs.capstone.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override  
	public UserDetails loadUserByUsername(String username) throws 
	      UsernameNotFoundException{
		
		User user =  userRepo.getUsersByUsername(username);
		return new MyUserDetails(user);
	}

}
