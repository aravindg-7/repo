package com.cognizant.mfrp.agile.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.model.BloodRequest;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.RequestRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.service.RequestService;

@RestController
@RequestMapping("/bloodrequest")
public class RequestController {
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RequestRepository rerepo;
	
	@Autowired
	private RequestService service;
	@PostMapping("/{id}")
	public void addrequest(@PathVariable String id,@RequestBody BloodRequest bloodreq){
//		User u= userrepo.findByUsername(id);
//		bloodreq.setUserId(u);
//		u.getRequests().add(bloodreq);
//		userrepo.save(u);
		service.addrequest(id, bloodreq);
	}
	
//	@DeleteMapping
//	public void deleterequest(@PathVariable String id,@RequestBody long reqid){
//		User u= userrepo.findByUsername(id);
//		u.getRequests().remove(reqid);
//		userrepo.save(u);
//	}
//	
//	

}
