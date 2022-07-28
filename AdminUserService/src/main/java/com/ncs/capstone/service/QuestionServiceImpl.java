package com.ncs.capstone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.capstone.exception.InvalidQuestionException;
import com.ncs.capstone.model.Question;
import com.ncs.capstone.repository.QuestionRepository;
import com.ncs.capstone.util.ValidateQuestion;


@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	ValidateQuestion validateQuestion;
	
	
	@Override
	public Question addQuestion(Question q) throws InvalidQuestionException {
		
		if(q != null) {
			boolean status = validateQuestion.validateQuestion(q);
			if(status == true) {
				
				Question savedQuestion = questionRepository.save(q);
				return savedQuestion;
			}else {
				throw new InvalidQuestionException("Question already exist", q.getQuestionString(),LocalDateTime.now());
			}
		}else {
			throw new NullPointerException("Question Info is Null");
		}
	}

	@Override
	public Question updateQuestion(Question q) {
		Question updatedQuestion = questionRepository.save(q);
		return updatedQuestion;
	}

	@Override
	public boolean deleteQuestionById(int id) {
		
		questionRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Question> getAllQuestions() {
		
		List<Question> questions = questionRepository.findAll();
		return questions;
	}

}
