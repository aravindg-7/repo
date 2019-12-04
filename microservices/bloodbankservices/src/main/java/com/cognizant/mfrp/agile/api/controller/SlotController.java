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

import com.cognizant.mfrp.agile.api.exception.AlreadyslotException;
import com.cognizant.mfrp.agile.api.exception.SlotBookedException;
import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.HospitalSlot;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.DonorRepository;
import com.cognizant.mfrp.agile.api.repository.SlotRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.service.SlotService;


@RestController
@RequestMapping("/hospitalslot")
public class SlotController {
	
	@Autowired
	private SlotService service;
	
//	@Autowired
//	private SlotRepository srepo;
	@Autowired
	private UserRepository userrepo;
//	@Autowired
//	private DonorRepository donorrepo;
	
	
	@PostMapping("/{id}")
	public boolean book(@PathVariable String id,@RequestBody HospitalSlot slot) throws SlotBookedException, AlreadyslotException{
		return service.book(id, slot);
	}
	
	@GetMapping("/{id}")
	public HospitalSlot getbook(@PathVariable String id){
		User u= userrepo.findByUsername(id);
		HospitalSlot hs= new HospitalSlot();
		hs=u.getDonor().getSlot();
		return hs;
	}
}
