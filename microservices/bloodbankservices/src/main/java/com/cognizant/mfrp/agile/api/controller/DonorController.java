package com.cognizant.mfrp.agile.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.Search;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.DonorRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.service.DonorService;

@RestController
@RequestMapping("/donate")
public class DonorController {
	@Autowired
	private DonorService service;
	@PostMapping("/{id}")
	public void donateform(@PathVariable String id,@RequestBody Donor donor){
//		User u=userrepo.findByUsername(id);
//		donor.setUser(u);
//		donorrepo.save(donor);
//		u.setDonor(donor);
//		userrepo.save(u);
		service.donateform(id,donor);
	}
	
	
	
}
