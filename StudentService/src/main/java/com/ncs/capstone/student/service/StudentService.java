package com.ncs.capstone.student.service;

import java.util.List;
import java.util.Set;

import com.ncs.capstone.student.model.Question;
import com.ncs.capstone.student.model.TestScore;

public interface StudentService {
	
	public TestScore addResult(List<Question> questions, int id);
	
}
