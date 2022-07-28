package com.ncs.capstone.result.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;

public class CustomResultRepositoryImpl implements CustomResultRepository {
	
	@Autowired
	EntityManager springDataJpa;

	@Override
	public List<TestScore> getResultByCategory(String category) {
		
		String query = "from TestScore ts where ts.category = :category";
		Query q = springDataJpa.createQuery(query);
		q.setParameter("category", category);
		
		List<TestScore> list = q.getResultList();
		return list;
	}

	@Override
	public List<TestScore> getReultsBylevel(String level) {
		
		String query = "from TestScore ts where ts.level = :level";
		Query q = springDataJpa.createQuery(query);
		q.setParameter("level", level);
		
		List<TestScore> list = q.getResultList();
		return list;
	}



	@Override
	public List<TestScore> getResultsByCategoryAndLevel(String category, String level) {
		
		String query = "from TestScore ts where ts.category = :category and ts.level = :level";
		Query q = springDataJpa.createQuery(query);
		q.setParameter("category", category);
		q.setParameter("level", level);
		
		List<TestScore> list = q.getResultList();
		return list;
	}

}
