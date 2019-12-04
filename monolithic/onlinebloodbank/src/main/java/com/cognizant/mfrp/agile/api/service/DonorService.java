package com.cognizant.mfrp.agile.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.DonorRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository donorrepo;
	@Autowired
	private UserRepository userrepo;
	
	public void donateform(String id,Donor donor){
		User u=userrepo.findByUsername(id);
		donor.setUser(u);
//		donorrepo.save(donor);
		u.setDonor(donor);
		userrepo.save(u);
	}
}
