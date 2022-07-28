package com.ncs.capstone.student.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ncs.capstone.student.model.TestScore;
import com.ncs.capstone.student.model.User;
import com.ncs.capstone.student.repository.StudentRepository;
import com.ncs.capstone.student.repository.TestScoreRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TestScoreRepository testScoreRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public TestScore addResult(TestScore ts, int id) {
		
		User user = studentRepository.getById(id);
		TestScore savedTestScore = testScoreRepository.save(ts);
		Set<TestScore> setOfScores = user.getAllTestScore();
		if (setOfScores != null) {
			setOfScores.add(savedTestScore);
			studentRepository.saveAndFlush(user);
		}else {
			Set<TestScore> set = new HashSet<>();
			set.add(ts);
			studentRepository.save(user);
		}
		return savedTestScore;
	}

}
