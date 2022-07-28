package com.ncs.capstone.quizquestion.repository;

import java.util.List;

import com.ncs.capstone.quizquestion.model.Question;

public interface CustomQuizQuestionRepository {
	public List<Question> getQuestionByCategoryAndLevel(String category, int difficulty);
}
