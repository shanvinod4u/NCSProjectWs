package com.ncs.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.capstone.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Query("from Question q where q.questionString = :question and q.difficulty = :difficulty")
	public Question getQuestionByQuestionAndLevel(String question, int difficulty);
}
