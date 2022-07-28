package com.ncs.capstone.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ncs.capstone.security.model.User;

@Service
public interface UserService extends UserDetailsService{
	
}
