package com.cognizant.mfrp.agile.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mfrp.agile.api.model.BloodRequest;

@Repository
public interface RequestRepository extends CrudRepository<BloodRequest,Long> {

}
