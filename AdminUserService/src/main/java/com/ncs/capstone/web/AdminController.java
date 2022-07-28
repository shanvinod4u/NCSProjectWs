package com.ncs.capstone.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncs.capstone.exception.InvalidUsernameException;
import com.ncs.capstone.model.Question;
import com.ncs.capstone.model.TestScore;
import com.ncs.capstone.model.User;
import com.ncs.capstone.service.QuestionService;
import com.ncs.capstone.service.UserService;

@RestController
@RequestMapping("/abc/admin")
@Validated
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	RestTemplate restTemplate;

	public AdminController() {
		super();
	}
	
	@PostMapping("user/addUser")
	public ResponseEntity<User> addUser(@RequestBody @Valid User u,@RequestHeader(name = "Authorization") String token) 
			throws Exception,InvalidUsernameException {
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
			User user = userService.addUser(u);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}else {
			throw new Exception("Only Admin can access this service");
		}
		
	}
	
	@PostMapping("question/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody @Valid Question q, User u,@RequestHeader(name = "Authorization") String token) throws Exception {
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		Question question = questionService.addQuestion(q);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@PutMapping("user/updateRole/{role}/{id}")
	public User updateRoleById(@PathVariable String role, @PathVariable int id, @RequestHeader(name = "Authorization") String token) throws Exception{
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		User u = userService.getUserById(id);
		User updatedUser = userService.updateUserRole(role, id);
		return updatedUser;
		}
		else {
		throw new Exception("Only Admin can access this service");
	}
		
	}
	
	@PutMapping("/question/updateQuestion")
	public Question updatedQuestion(@RequestBody Question q, @RequestHeader(name = "Authorization") String token) throws Exception {
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		
		if(jwtStatus) {
		Question updateQuestion = questionService.updateQuestion(q);
		return updateQuestion;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id, @RequestHeader(name = "Authorization") String token) throws Exception {
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		User user = userService.getUserById(id);
		return user;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@GetMapping("/user/allUsers")
	public List<User> getAllUsers(@RequestHeader(name = "Authorization") String token) throws Exception {
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		List<User> users = userService.getAllUsers();
		return users;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	
	@GetMapping("/question/allQuestions")
	public List<Question> getAllQuestions(@RequestHeader(name = "Authorization") String token) throws Exception {
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		List<Question> questions = questionService.getAllQuestions();
		return questions;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@GetMapping("/result/{category}")
	public List<TestScore> getResultsByCategory(@PathVariable String category,@RequestHeader(name = "Authorization") String token) throws Exception {
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		List<TestScore> list = restTemplate.getForObject("http://QuizApp-Result-Service/api/result/category/"+category, List.class);
		return list;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@DeleteMapping("/user/delete/{id}")
	public List<User> deleteUserById(@PathVariable int id,@RequestHeader(name = "Authorization") String token) throws Exception{
		
		String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		boolean status = userService.deleteUserById(id);
		
		if(status == true) {
			List<User> users = userService.getAllUsers();
			return users;
		}
		else return null;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	
	@DeleteMapping("/question/delete/{id}")
	public List<Question> deleteQuestionById(@PathVariable int id,@RequestHeader(name = "Authorization") String token) throws Exception{
	String endPoint = "http://QuizApp-Security-Service/public/validate";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", token);
		headers.set("userType","admin");

		HttpEntity<String> header = new HttpEntity<String>(headers);
		ResponseEntity<Boolean> result = restTemplate.exchange(endPoint, HttpMethod.GET, header, Boolean.class);
		//boolean result = restTemplate.getForObject(endPoint, header, Boolean.class);
		
		boolean jwtStatus = result.getBody();
		if(jwtStatus) {
		boolean status = questionService.deleteQuestionById(id);
		
		if(status == true) {
			List<Question> questions = questionService.getAllQuestions();
			return questions;
		}
		else return null;
		}else {
			throw new Exception("Only Admin can access this service");
		}
	}
	

}
