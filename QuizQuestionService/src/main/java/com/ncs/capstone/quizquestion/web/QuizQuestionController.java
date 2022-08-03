package com.ncs.capstone.quizquestion.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.capstone.quizquestion.model.Question;
import com.ncs.capstone.quizquestion.service.QuizQuestionService;

@RestController
@RequestMapping("/api/quizQuestion")
public class QuizQuestionController {
	
	@Autowired
	QuizQuestionService quizQuestionService;
	
	@GetMapping("/questions/{category}/{difficulty}")
	public List<Question> getQuestionByCategoryAndLevel(@PathVariable String category, @PathVariable int difficulty) {
		
		List<Question> list = quizQuestionService.getQuestionByCategoryAndLevel(category, difficulty);
		return list;
	}
	
	@GetMapping("/questions/{id}")
	public Question getQuestionById(@PathVariable int id) {
		
		Question question = quizQuestionService.getQuestionById(id);
		return question;
		
	}

}
