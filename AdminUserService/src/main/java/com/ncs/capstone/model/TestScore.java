package com.ncs.capstone.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class TestScore implements Serializable, Comparable<TestScore> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int testId;
	private String date;
	private String category;
	private String level;
	private int totalScore;
	private int marks;
	

	
	public TestScore() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TestScore(int testId, String date, String category, String level, int totalScore, int marks) {
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
	public String toString() {
		return "TestScore [testId=" + testId + ", date=" + date + ", category=" + category + ", level=" + level
				+ ", totalScore=" + totalScore + ", marks=" + marks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, date, level, marks, testId, totalScore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestScore other = (TestScore) obj;
		return Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(level, other.level) && marks == other.marks && testId == other.testId
				&& totalScore == other.totalScore;
	}

	@Override
	public int compareTo(TestScore ts) {
		return this.testId - ts.testId;
	}
	
}
