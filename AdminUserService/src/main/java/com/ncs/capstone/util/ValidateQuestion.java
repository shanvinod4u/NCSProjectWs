package com.ncs.capstone.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.capstone.model.Question;
import com.ncs.capstone.repository.QuestionRepository;

@Component
public class ValidateQuestion {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public boolean validateQuestion(Question q) {
		
		String question = q.getQuestionString();
		int difficulty = q.getDifficulty();
		Question existingQuestion = questionRepository.getQuestionByQuestionAndLevel(question, difficulty);
		
		if(existingQuestion != null) {
				return false;
		}else {
			return true;
		}
	}
}
