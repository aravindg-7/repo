package com.cognizant.mfrp.agile.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.mfrp.agile.api.model.Role;
import com.cognizant.mfrp.agile.api.model.User;
import com.cognizant.mfrp.agile.api.repository.RoleRepository;
import com.cognizant.mfrp.agile.api.repository.UserRepository;
import com.cognizant.mfrp.agile.api.security.AppUser;






@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userrepository;
	@Autowired
	RoleRepository rolerepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User u=userrepository.findByUsername(name);
		System.out.println("in");
		if(u== null){
			throw new UsernameNotFoundException("no user");
		}
		else
		System.out.println("user is"+u.getUsername());	
		AppUser au= new AppUser(u);
		return au;
	}
	public AppUserDetailsService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	public boolean signup(User newuser){
		User u=userrepository.findByUsername(newuser.getUsername());
		if(u==null)
		{
			String password=newuser.getPassword();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			String newpassword=encoder.encode(password);
			Role role= rolerepository.findById(1).get();
			List<Role> roleset= new ArrayList<Role>();
			roleset.add(role);
			newuser.setRoles(roleset);
			newuser.setPassword(newpassword);
			userrepository.save(newuser);
			return true;
		}
		else
			return false;
	}
	

}

