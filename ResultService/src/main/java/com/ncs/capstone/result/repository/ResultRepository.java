package com.ncs.capstone.result.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.capstone.result.model.TestScore;

public interface ResultRepository extends JpaRepository<TestScore, Integer>, CustomResultRepository {
	
	@Query(value = "select * from test_score where user_info = :id", nativeQuery= true)
	public List<TestScore> getResultByUserId(int id);
}
