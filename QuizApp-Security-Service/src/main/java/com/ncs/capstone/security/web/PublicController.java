package com.ncs.capstone.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.capstone.security.dto.JWTResponseDTO;
import com.ncs.capstone.security.dto.UserRequestDTO;
import com.ncs.capstone.security.jwtutil.JWTUtil;
import com.ncs.capstone.security.model.User;
import com.ncs.capstone.security.repository.UserRepository;
import com.ncs.capstone.security.service.UserServiceImpl;

@RestController
@RequestMapping("/abc/public")
public class PublicController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserServiceImpl appUserServiceImpl;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JWTResponseDTO> doLogin(@RequestBody UserRequestDTO userEntry)throws Exception
	{
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getUsername(), userEntry.getPassword()));
			System.out.println();
			
		} catch (Exception e) {
			throw new Exception("Please input valid username and password");
		}

		UserDetails userDetails =  appUserServiceImpl.loadUserByUsername(userEntry.getUsername());
		
		User user = userRepo.getUsersByUsername(userEntry.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		boolean isValid = token!=null?true:false;
		
		JWTResponseDTO jwtResponseDTO = new JWTResponseDTO(token,userEntry.getUsername(),isValid,user.getRole(),user.getUserId());
		
		return new ResponseEntity<JWTResponseDTO>(jwtResponseDTO, HttpStatus.OK);
	}
}
