package com.ncs.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.capstone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
	
	@Query("from User u where u.username= :username")
	public User getUserByUsername(String username);
	
	@Query("from User u where u.email = :email")
	public User getUserByEmail(String email);
}
