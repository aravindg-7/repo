package com.cognizant.mfrp.agile.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.model.BloodRequest;
import com.cognizant.mfrp.agile.api.repository.RequestRepository;
@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private RequestRepository reqrepo;
	@GetMapping
	public List<BloodRequest> getallreq(){
//		Authentication authentication = 
//				SecurityContextHolder.getContext().getAuthentication();
//				String user = authentication.getName();
//				if(!user.equalsIgnoreCase("anonymousUser")){
		List<BloodRequest> li= new ArrayList<BloodRequest>();
		reqrepo.findAll().forEach(li::add);
		return li;
//		}
//				else{
//					List<BloodRequest> li= new ArrayList<BloodRequest>();
//					reqrepo.findAll().forEach(li::add);
//					return li;}
	}
}
