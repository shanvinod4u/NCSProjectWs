package com.ncs.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ncs.capstone.exception.InvalidQuestionException;
import com.ncs.capstone.model.Question;


public interface QuestionService {
	
	public Question addQuestion(Question q) throws InvalidQuestionException ;
	public List<Question> getAllQuestions();
	public Question updateQuestion(Question q);
	public boolean deleteQuestionById(int id);
	
}
