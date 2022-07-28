package com.ncs.capstone.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.capstone.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{
	@Query("from User where username = :username")
	public User getUsersByUsername(String username);
}
