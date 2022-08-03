package com.ncs.capstone.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.capstone.student.dto.TestScoreResponseDTO;
import com.ncs.capstone.student.model.Question;
import com.ncs.capstone.student.model.TestScore;
import com.ncs.capstone.student.service.StudentService;

@RestController
@RequestMapping("/abc/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	RestTemplate restTemplate;

	public StudentController() {
		super();
	}
	
	@PostMapping("/submit/exam/{id}")
	public TestScore addResult(@RequestBody List<Question> questions, @PathVariable int id){
		
		TestScore savedTestScore = studentService.addResult(questions, id);
		return savedTestScore;
	}
	
	@GetMapping("/result/history/{id}")
	public ResponseEntity<List<TestScoreResponseDTO>> getStudentExamHistory(@PathVariable int id){
		
		List<TestScoreResponseDTO> list = restTemplate.getForObject("http://QuizApp-Result-Service/api/result/user/"+id, List.class);
		
		return new ResponseEntity<List<TestScoreResponseDTO>>(list, HttpStatus.OK);
		
	}

	@GetMapping("/exam/{category}/{difficulty}")
	public List<Question> getExamQuestions(@PathVariable String category, @PathVariable int difficulty){
		
		List<Question> list = 
				restTemplate.getForObject("http://QuizApp-Question-Service/api/quizQuestion/questions/"+category+"/"+difficulty, List.class);
		return list;
	}
	
}
