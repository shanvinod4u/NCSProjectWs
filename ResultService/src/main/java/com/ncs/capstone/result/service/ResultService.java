package com.ncs.capstone.result.service;

import java.util.List;
import java.util.Set;

import com.ncs.capstone.result.dto.TestScoreResponseDTO;
import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;

public interface ResultService {
	
	public List<TestScore> getResultByCategory(String category);
	public List<TestScore> getReultsBylevel(String level);
	public List<TestScore> getResultsByCategoryAndLevel(String category, String level);
	public List<TestScore> getResultsByStudentId(int id);
}
