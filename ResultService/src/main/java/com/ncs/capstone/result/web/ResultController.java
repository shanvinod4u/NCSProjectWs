package com.ncs.capstone.result.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.capstone.result.dto.TestScoreResponseDTO;
import com.ncs.capstone.result.model.TestScore;
import com.ncs.capstone.result.model.User;
import com.ncs.capstone.result.service.ResultService;
import com.ncs.capstone.result.util.TestScoreConversionDTO;

@RestController
@RequestMapping("/api/result")
public class ResultController {
	
	@Autowired
	ResultService resultService;

	public ResultController() {
		super();
	}
	
	@GetMapping("/category/{category}")
	public List<TestScore> getResultByCategory(@PathVariable String category) { 
		
		List<TestScore> list = resultService.getResultByCategory(category);
		return list;
	}
	
	@GetMapping("/{level}")
	public List<TestScore> getResultByLevel(@PathVariable String level) { 
		
		List<TestScore> list = resultService.getReultsBylevel(level);
		return list;
	}
	

	
	@GetMapping("/{category}/{level}")
	public List<TestScore> getResultsByCategoryAndLevel(@PathVariable String category,@PathVariable String level) { 
		
		List<TestScore> list = resultService.getResultsByCategoryAndLevel(category, level);
		return list;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<TestScoreResponseDTO>>getResultsByStudentId(@PathVariable int id) { 
		
		List<TestScore> list = resultService.getResultsByStudentId(id);
		List<TestScoreResponseDTO> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(TestScoreConversionDTO.convertToResponse(list.get(i)));
		}
		
		return new ResponseEntity<List<TestScoreResponseDTO>>(result, HttpStatus.OK);
	}
	
	
}
