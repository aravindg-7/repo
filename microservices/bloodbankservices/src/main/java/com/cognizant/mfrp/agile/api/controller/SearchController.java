package com.cognizant.mfrp.agile.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.Search;
import com.cognizant.mfrp.agile.api.repository.DonorRepository;

@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private DonorRepository donorrepo;
	@PostMapping
	public List<Donor> donorsearch(@RequestBody Search search){
		List<Donor> dl= new ArrayList<Donor>();
		List<Donor> newdl= new ArrayList<Donor>();
		donorrepo.findAll().forEach(dl::add);
		List<Donor> edl= new ArrayList<Donor>();
		for(int i=0;i<dl.size();i++){
			Date curdate=new Date();
			long duration= curdate.getTime() - dl.get(i).getSlot().getSlotdate().getTime();
			long days=TimeUnit.MILLISECONDS.toDays(duration);
			if(days>95){
				edl.add(dl.get(i));
			}}
		for(int j=0;j<edl.size();j++){
			if(edl.get(j).getBloodGroup().equalsIgnoreCase(search.getBloodGroup())&&
					edl.get(j).getState().equalsIgnoreCase(search.getState())&&
					edl.get(j).getArea().equalsIgnoreCase(search.getArea())&&
					edl.get(j).getPincode()==search.getPincode()){
				newdl.add(edl.get(j));
			}
		}
		
		return newdl;
	}
}
