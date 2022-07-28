package com.ncs.capstone.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;



public class CustomUserRepositoryImpl implements CustomUserRepository {
	
	@Autowired
	EntityManager springDataJPA;
	
	@Override
	@Transactional
	public boolean updateUserRole(String role, int id) {
		
		String query = "Update User set role = :role where userId = :id";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("role", role);
		q.setParameter("id", id);
		int x = q.executeUpdate();
		
		return (x==1)?true:false;
	}

}
