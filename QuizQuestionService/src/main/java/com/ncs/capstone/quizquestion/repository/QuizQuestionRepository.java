package com.ncs.capstone.quizquestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.capstone.quizquestion.model.Question;

public interface QuizQuestionRepository extends 
JpaRepository<Question, Integer>, 
CustomQuizQuestionRepository{

}
