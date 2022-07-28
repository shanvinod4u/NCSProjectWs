package com.ncs.capstone.result.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ncs.capstone.result.dto.TestScoreResponseDTO;
import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;
import com.ncs.capstone.result.repository.ResultRepository;
import com.ncs.capstone.result.repository.UserRepository;


@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<TestScore> getResultByCategory(String category) {

		List<TestScore> list = resultRepository.getResultByCategory(category);
		return list;
	}

	@Override
	public List<TestScore> getReultsBylevel(String level) {
		
		List<TestScore> list = resultRepository.getReultsBylevel(level);
		return list;
	}


	@Override
	public List<TestScore> getResultsByCategoryAndLevel(String category, String level) {

		List<TestScore> list = resultRepository.getResultsByCategoryAndLevel(category, level);
		return list;
	}

	@Override
	public List<TestScore> getResultsByStudentId(int id) {
		
		List<TestScore> list = resultRepository.getResultByUserId(id);
		return list;
	}

}
