package com.ncs.capstone.quizquestion.service;

import java.util.List;

import com.ncs.capstone.quizquestion.model.Question;

public interface QuizQuestionService {
	
	public List<Question> getQuestionByCategoryAndLevel(String category, int difficulty);

}
