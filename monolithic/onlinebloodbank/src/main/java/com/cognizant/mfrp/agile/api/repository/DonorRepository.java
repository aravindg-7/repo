package com.cognizant.mfrp.agile.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mfrp.agile.api.model.Donor;

@Repository
public interface DonorRepository extends CrudRepository<Donor,Long> {

}
