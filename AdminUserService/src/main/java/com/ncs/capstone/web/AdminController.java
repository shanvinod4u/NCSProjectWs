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
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.ncs.capstone.exception.InvalidEmailException;
import com.ncs.capstone.exception.InvalidQuestionException;
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
	public ResponseEntity<User> addUser(@RequestBody @Valid User u)throws InvalidUsernameException, InvalidEmailException {

			User user = userService.addUser(u);
			return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
	@PostMapping("question/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody @Valid Question q) throws InvalidQuestionException{

		Question question = questionService.addQuestion(q);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
		
	}
	
	@PutMapping("user/updateUser")
	public User updateRoleById(@RequestBody User u){
		
		User updatedUser = userService.updateUser(u);
		return updatedUser;
		
	}
	
	@PutMapping("/question/updateQuestion")
	public Question updatedQuestion(@RequestBody Question q) {
		
		Question updateQuestion = questionService.updateQuestion(q);
		return updateQuestion;
		
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id)  {

		User user = userService.getUserById(id);
		return user;
		
	}
	
	@GetMapping("/question/{id}")
	public Question getQuestionById(@PathVariable int id) {
		
		Question question = questionService.getQuestionById(id);
		return question;
	}
	
	@GetMapping("/user/allUsers")
	public List<User> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	
	@GetMapping("/question/allQuestions")
	public List<Question> getAllQuestions() {
		
		List<Question> questions = questionService.getAllQuestions();
		return questions;
	}
	
	@GetMapping("/result/{category}")
	public List<TestScore> getResultsByCategory(@PathVariable String category)  {
		List<TestScore> list = restTemplate.getForObject("http://QuizApp-Result-Service/api/result/category/"+category, List.class);
		return list;
	}
	
	@DeleteMapping("/user/delete/{id}")
	public List<User> deleteUserById(@PathVariable int id){
		

		boolean status = userService.deleteUserById(id);
		
		if(status == true) {
			List<User> users = userService.getAllUsers();
			return users;
		}
		else return null;
	}
	
	@DeleteMapping("/question/delete/{id}")
	public List<Question> deleteQuestionById(@PathVariable int id){
	
		boolean status = questionService.deleteQuestionById(id);
		
		if(status == true) {
			List<Question> questions = questionService.getAllQuestions();
			return questions;
		}
		else return null;
	}

}
