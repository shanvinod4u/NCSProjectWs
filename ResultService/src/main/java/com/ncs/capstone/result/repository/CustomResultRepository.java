package com.ncs.capstone.result.repository;

import java.util.List;

import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;

public interface CustomResultRepository {
	
	public List<TestScore> getResultByCategory(String category);
	public List<TestScore> getReultsBylevel(String level);
	public List<TestScore> getResultsByCategoryAndLevel(String category, String level);
	
}
