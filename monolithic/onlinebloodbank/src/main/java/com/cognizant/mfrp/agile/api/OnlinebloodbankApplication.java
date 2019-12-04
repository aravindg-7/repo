package com.cognizant.mfrp.agile.api;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.mfrp.agile.api.model.HospitalSlot;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.RequestRepository;
import com.cognizant.mfrp.agile.api.repository.SlotRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;

@SpringBootApplication
public class OnlinebloodbankApplication {
	@Autowired
	private static RequestRepository repository;
	
	@Autowired
	private static UserRepository urepository;
	
	@Autowired
	private static SlotRepository srepo;
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OnlinebloodbankApplication.class, args);
		repository= context.getBean(RequestRepository.class);
		urepository=context.getBean(UserRepository.class);
		srepo=context.getBean(SlotRepository.class);
//		testaddreq();
//		test();
	}
	

	
//	private static void test(){
//		HospitalSlot hs=new HospitalSlot();
//		hs.setCity("Chennai");
//		hs.setHospitalname("Apollo");
//		hs.setTimeslot("9 to 10");
//		 String str="2015-03-31";
//		 Date d= Date.valueOf(str);
//		 hs.setSlotdate(d);
//		 User u=urepository.findById(1).get();
//		 hs.setUser(u);
//		 srepo.save(hs);
//	}
	
	
	

}
