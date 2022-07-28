package com.ncs.capstone.quizquestion.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.capstone.quizquestion.model.Question;

public class CustomQuizQuestionRepositoryImpl implements CustomQuizQuestionRepository{
	
	@Autowired
	EntityManager springDataJpa;
	
	@Override
	public List<Question> getQuestionByCategoryAndLevel(String category, int difficulty) {

		String query = "from Question q where q.category= :category AND q.difficulty= :difficulty ";
		Query q = springDataJpa.createQuery(query);
		q.setParameter("category", category);
		q.setParameter("difficulty", difficulty);
		
		List<Question> list = q.getResultList();
		
		return list;
	}

}
