package com.cognizant.mfrp.agile.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mfrp.agile.api.exception.AlreadyslotException;
import com.cognizant.mfrp.agile.api.exception.SlotBookedException;
import com.cognizant.mfrp.agile.api.model.Donor;
import com.cognizant.mfrp.agile.api.model.HospitalSlot;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.DonorRepository;
import com.cognizant.mfrp.agile.api.repository.SlotRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;

@Service
public class SlotService {
	
	@Autowired
	private SlotRepository srepo;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private DonorRepository donorrepo;
	@Transactional
	public boolean book(String id,HospitalSlot slot) throws SlotBookedException, AlreadyslotException{
		List<HospitalSlot> hs= new ArrayList<HospitalSlot>();
//		boolean status=false;
		srepo.findAll().forEach(hs::add);
		User u= userrepo.findByUsername(id);
		Donor donor=u.getDonor();
		System.out.println("in");
		System.out.println(slot);
		System.out.println(donor.getId()+""+donor.getSlot());
//		HospitalSlot temp=srepo.findById(donor.getId()).get();
//		System.out.println(temp);
		if(donor.getSlot()!=null){
			Date curdate=new Date();
			long duration= curdate.getTime() - donor.getSlot().getSlotdate().getTime();
			long days=TimeUnit.MILLISECONDS.toDays(duration);
			System.out.println(duration);
			System.out.println(days);
			if(days>95){
				slot.setDonor(donor);
				donor.setSlot(slot);
				donorrepo.save(donor);
				System.out.println("am saving");
				return false;
			}
			else
				System.out.println("throwing exception");
				throw new AlreadyslotException();

		}
		for(int i=0;i<hs.size();i++){
			int test=slot.getSlotdate().compareTo(hs.get(i).getSlotdate());
			System.out.println(test);
			if(slot.getTimeslot().equalsIgnoreCase(hs.get(i).getTimeslot())&&test==1&&
					slot.getHospitalname().equalsIgnoreCase(hs.get(i).getHospitalname())&&
					slot.getCity().equalsIgnoreCase(hs.get(i).getCity())){
//				status=true;
				System.out.println("in exception");
				throw new SlotBookedException();
			}
		
		}
		System.out.println("outside");
		slot.setDonor(donor);
		slot.setId(donor.getId());
		donor.setSlot(slot);
		donorrepo.save(donor);
//		u.setDonor(donor);
//		userrepo.save(u);
		return false;
	}
}
