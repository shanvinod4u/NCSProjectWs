package com.ncs.capstone.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public TestScore addResult(@RequestBody TestScore ts, @PathVariable int id,@RequestHeader(name = "Authorization") String token) throws Exception {
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","student");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		TestScore savedTestScore = studentService.addResult(ts, id);
		return savedTestScore;
		}else {
			throw new Exception("Only Student can access this service");
		}
	}
	
	@GetMapping("/result/history/{id}")
	public ResponseEntity<List<TestScoreResponseDTO>> getStudentExamHistory(@PathVariable int id,@RequestHeader(name = "Authorization") String token) throws Exception{
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","student");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		List<TestScoreResponseDTO> list = restTemplate.getForObject("http://QuizApp-Result-Service/api/result/user/"+id, List.class);
		
		return new ResponseEntity<List<TestScoreResponseDTO>>(list, HttpStatus.OK);
		}else {
			throw new Exception("Only Student can access this service");
		}
	}

	@GetMapping("/exam/{category}/{difficulty}")
	public List<Question> getExamQuestions(@PathVariable String category, @PathVariable int difficulty,@RequestHeader(name = "Authorization") String token) throws Exception{
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","student");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		List<Question> list = 
				restTemplate.getForObject("http://QuizApp-Question-Service/api/quizQuestion/questions/"+category+"/"+difficulty, List.class);
		return list;
		}else {
			throw new Exception("Only Student can access this service");
		}
	}
	
}
