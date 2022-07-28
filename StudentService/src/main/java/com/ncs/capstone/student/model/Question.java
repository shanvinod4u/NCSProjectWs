package com.ncs.capstone.student.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Question implements Serializable, Comparable<Question> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String questionString;
	private String category;
	private int difficulty;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String questionString, String category, int difficulty, String option1, String option2,
			String option3, String option4, String correctAnswer) {
		super();
		this.questionString = questionString;
		this.category = category;
		this.difficulty = difficulty;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, correctAnswer, difficulty, option1, option2, option3, option4, questionId,
				questionString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(category, other.category) && Objects.equals(correctAnswer, other.correctAnswer)
				&& difficulty == other.difficulty && Objects.equals(option1, other.option1)
				&& Objects.equals(option2, other.option2) && Objects.equals(option3, other.option3)
				&& Objects.equals(option4, other.option4) && questionId == other.questionId
				&& Objects.equals(questionString, other.questionString);
	}

	@Override
	public int compareTo(Question q) {
		return this.questionId - q.questionId;
	}
	
}
