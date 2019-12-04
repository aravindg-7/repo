package com.cognizant.mfrp.agile.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.OnlinebloodbankApplication;
import com.cognizant.mfrp.agile.api.exception.UserAlreadyExistsException;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.service.AppUserDetailsService;





@RestController
@RequestMapping("/users") 
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OnlinebloodbankApplication.class);
	
	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	private AppUserDetailsService detailservice;
	
	@Autowired
	private UserRepository repository;
	
//	@PostMapping
//	public boolean signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
//		
//			if(inMemoryUserDetailsManager.userExists(user.getUsername())){
//				throw new UserAlreadyExistsException();
//				
//			}
//			else{
//				
//				inMemoryUserDetailsManager.createUser(
//						org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//						.password(new BCryptPasswordEncoder().encode(user.getPassword()))
//						.roles("USER").build());
//				return true;
//			}
//			
//	}
      
	@PostMapping
	public boolean signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		if(detailservice.signup(user))
			return detailservice.signup(user);
		else
			throw new UserAlreadyExistsException();
	}
	@GetMapping("/{id}")
	public User getMovie(@PathVariable int id){
		return repository.findById(id).get();
	}
}
