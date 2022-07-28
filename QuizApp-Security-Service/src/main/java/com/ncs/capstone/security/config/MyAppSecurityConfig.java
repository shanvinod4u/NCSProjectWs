package com.ncs.capstone.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ncs.capstone.security.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.

		 	csrf().disable().cors().disable().
			authorizeRequests().

			antMatchers("/abc/public/**").permitAll().
			antMatchers("/abc/admin/**").hasAuthority("admin").
			antMatchers("/abc/student/**").hasAuthority("student").
			
			anyRequest().authenticated().and().
			sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 
		 http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	} 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		
	}

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();
	}
	
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
		 
		
		 
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	 }
	
	 @Bean
	 public AuthenticationManager authenticationManagerBean()throws Exception
	 {
		 return super.authenticationManagerBean();
	 }

}//end class
