package com.ncs.capstone.repository;

import com.ncs.capstone.model.User;

public interface CustomUserRepository {
	
	public boolean updateUserRole(String role, int id);
}
