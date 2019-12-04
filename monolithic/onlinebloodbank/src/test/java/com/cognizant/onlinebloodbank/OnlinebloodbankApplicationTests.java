package com.cognizant.onlinebloodbank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.mfrp.agile.api.OnlinebloodbankApplication;
import com.cognizant.mfrp.agile.api.exception.AlreadyslotException;
import com.cognizant.mfrp.agile.api.exception.SlotBookedException;
import com.cognizant.mfrp.agile.api.model.BloodRequest;
import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.HospitalSlot;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.service.DonorService;
import com.cognizant.mfrp.agile.api.service.RequestService;
import com.cognizant.mfrp.agile.api.service.SlotService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OnlinebloodbankApplication.class)
public class OnlinebloodbankApplicationTests {
		
	@Autowired
	private UserRepository urepository;
	@Autowired
	private RequestService service;
	
	@Autowired
	private DonorService doservice;
	
	@Autowired
	private SlotService slotservice;
	
	@Test
	 public void testaddreq(){
	BloodRequest br= new BloodRequest();
	br.setArea("Panaji");
	br.setBloodGroup("O-");
	br.setContactNumber("9111111119");
	br.setState("Goa");
	br.setPincode(123456);
	User u=urepository.findByUsername("thor");
	service.addrequest(u.getUsername(), br);
	boolean st = false;
	for(int i=0;i<u.getRequests().size();i++){
		if(u.getRequests().get(i).getContactNumber().equalsIgnoreCase("9111111119"))
			st=true;
	}
	assertEquals(st,true);
	}
	
	@Test
	public void testdonor(){
		Donor dr= new Donor();
		dr.setArea("Andaman and Nicobar Islands");
		dr.setBloodGroup("O+");
		dr.setContactNumber("1234561234");
		dr.setState("Andaman and Nicobar Islands");
		doservice.donateform("thor", dr);
		User u=urepository.findByUsername("thor");
		assertEquals(u.getDonor().getBloodGroup(),"O+");
	}
	@Test
	public void testslot(){
		HospitalSlot hs=new HospitalSlot();
		hs.setCity("Bangalore");
		hs.setHospitalname("Apollo");
		hs.setTimeslot("9 to 10");
		 String str="2019-11-11";
		 Date d= Date.valueOf(str);
		 hs.setSlotdate(d);
//		 User u=urepository.findByUsername("thor");
			
//		 boolean st=false;
//		 if(u.getDonor().getSlot()!=null)
//			 st=true;
		 try {
			slotservice.book("thor",hs);
			fail();
		} catch (SlotBookedException | AlreadyslotException e) {
			// TODO Auto-generated catch block
			String expected="Slot already booked";
			assertEquals(expected,e.getMessage());
		}
	}
	@Test
	public void testexception(){
		HospitalSlot hs=new HospitalSlot();
		hs.setCity("Bangalore");
		hs.setHospitalname("Apollo");
		hs.setTimeslot("9 to 10");
		 String str="2019-12-02";
		 Date d= Date.valueOf(str);
		 hs.setSlotdate(d);
//		 User u=urepository.findByUsername("thor");
			
//		 boolean st=false;
//		 if(u.getDonor().getSlot()!=null)
//			 st=true;
		 try {
			slotservice.book("realuser",hs);
			fail();
		} catch (SlotBookedException | AlreadyslotException e) {
			// TODO Auto-generated catch block
			String expected="You have an active slot";
			assertEquals(expected,e.getMessage());
		}
	}


}
