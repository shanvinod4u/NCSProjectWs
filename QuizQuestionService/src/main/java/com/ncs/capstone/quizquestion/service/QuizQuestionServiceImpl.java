package com.ncs.capstone.quizquestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.capstone.quizquestion.model.Question;
import com.ncs.capstone.quizquestion.repository.QuizQuestionRepository;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionService {
	
	@Autowired
	QuizQuestionRepository quizQuestionRepository;

	@Override
	public List<Question> getQuestionByCategoryAndLevel(String category, int difficulty) {

		List<Question> list = quizQuestionRepository.getQuestionByCategoryAndLevel(category, difficulty);
		return list;
	}

	@Override
	public Question getQuestionById(int id) {
		Question question = quizQuestionRepository.getById(id);
		return question;
	}
	
}
