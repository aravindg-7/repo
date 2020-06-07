package com.cognizant.mfrp.agile.api.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.AuthonlinebloodbankApplication;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthonlinebloodbankApplication.class);
	@Autowired
	private UserRepository repository;
	@GetMapping
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("start");
		LOGGER.info(authHeader);
		Map<String,String> authmap= new HashMap<String,String>();
		authmap.put("token",generateJwt(getUser(authHeader)));
//		String role = SecurityContextHolder.getContext().getAuthentication()
//                .getAuthorities().toArray()[0].toString();
//		authmap.put("role",getUser(authHeader));
		String username =  getUser(authHeader);
        authmap.put("username", username);
        User user = repository.findByUsername(username);
        String role = user.getRoles().get(0).getName();
        String firstname = user.getFirstName();
        String lastname = user.getLastName();
        authmap.put("role", role);
        authmap.put("firstname", firstname);
        authmap.put("lastname", lastname);
        LOGGER.info("END OF AUTH FUNCTION");
		return authmap;
	}
	private String getUser(String authHeader){
		String user=new String(Base64.getDecoder().decode(authHeader.substring(6)));
		user= user.substring(0, user.indexOf(":"));
		LOGGER.info(user);
		return user;
	}
	private String generateJwt(String user){
		JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());

        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.info(token);
        return token;
	}
}