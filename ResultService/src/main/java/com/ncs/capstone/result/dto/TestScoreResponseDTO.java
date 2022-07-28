package com.ncs.capstone.result.dto;

import org.springframework.stereotype.Component;

import com.google.common.base.Objects;

@Component
public class TestScoreResponseDTO {

	private int testId;
	private String date;
	private String category;
	private String level;
	private int totalScore;
	private int marks;

	public TestScoreResponseDTO() {
		super();
	}

	public TestScoreResponseDTO(int testId, String date, String category, String level, int totalScore, int marks) {
		super();
		this.testId = testId;
		this.date = date;
		this.category = category;
		this.level = level;
		this.totalScore = totalScore;
		this.marks = marks;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	

	@Override
	public int hashCode() {
		return java.util.Objects.hash(category, date, level, marks, testId, totalScore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestScoreResponseDTO other = (TestScoreResponseDTO) obj;
		return java.util.Objects.equals(category, other.category) && java.util.Objects.equals(date, other.date)
				&& java.util.Objects.equals(level, other.level) && marks == other.marks && testId == other.testId
				&& totalScore == other.totalScore;
	}

	@Override
	public String toString() {
		return "TestScoreResponseDTO [testId=" + testId + ", date=" + date + ", category=" + category + ", level="
				+ level + ", totalScore=" + totalScore + ", marks=" + marks + "]";
	}

}
