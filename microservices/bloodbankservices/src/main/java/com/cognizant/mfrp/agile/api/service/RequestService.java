package com.cognizant.mfrp.agile.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.mfrp.agile.api.model.BloodRequest;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.RequestRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;

@Service
public class RequestService {
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RequestRepository rerepo;
	@Autowired
	private RequestService service;
	public void addrequest( String id,BloodRequest bloodreq){
		User u= userrepo.findByUsername(id);
		bloodreq.setUserId(u);
		u.getRequests().add(bloodreq);
		userrepo.save(u);
	}
}
