package com.ncs.capstone.student.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ncs.capstone.student.model.Question;
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
	public TestScore addResult(List<Question> questions, int id) {
		int totalScore = 0;
		String category;
		String level;
		int marks;
		for(Question ques: questions) {
			Question question = restTemplate.getForObject("http://QuizApp-Question-Service/api/quizQuestion/questions/"+ ques.getQuestionId(),
					Question.class);
			if(ques.getGivenAnswer().trim().equals(question.getCorrectAnswer().trim())) {
				totalScore = totalScore+1;
			}
		}
		category = questions.get(0).getCategory();
		if(questions.get(0).getDifficulty()== 1) {
			level = "basic";
		}else if (questions.get(0).getDifficulty()== 2) {
			level = "intermediate";
		}else if (questions.get(0).getDifficulty()== 3) {
			level = "advance";
		}else {
			level = null;
		}
		
		marks = (totalScore * 100)/10;
		
		LocalDate today = LocalDate.now();
		String date = today.toString();
		
		User user = studentRepository.getById(id);
		TestScore ts = new TestScore();
		ts.setDate(date);
		ts.setCategory(category);
		ts.setLevel(level);
		ts.setTotalScore(totalScore);
		ts.setMarks(marks);
		
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
