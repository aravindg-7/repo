package com.cognizant.mfrp.agile.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mfrp.agile.api.model.User;




@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

	public User findByUsername(String name);
	
	

}
