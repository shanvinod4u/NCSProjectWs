package com.ncs.capstone.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ncs.capstone.security.jwtutil.JWTUtil;
import com.ncs.capstone.security.service.UserService;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter{

	String orgKey = "ncs-";
	
	@Autowired
	UserService AppUserService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestedTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		 
		if(requestedTokenHeader !=null && requestedTokenHeader.startsWith(orgKey))
		{
				jwtToken = requestedTokenHeader.substring(4);
				
				try {
					
					username = jwtUtil.extractUsername(jwtToken);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				 if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			            UserDetails userDetails = this.AppUserService.loadUserByUsername(username);

			            if (jwtUtil.validateToken(jwtToken, userDetails)) {

			                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
			                		new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			               
			                usernamePasswordAuthenticationToken
			                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			            }
			        }				
				
		}
		else
		{
			System.out.println("Token is not validated");
		}
		
		filterChain.doFilter(request, response);
	
	}
	
	
}
