package com.cognizant.mfrp.agile.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mfrp.agile.api.model.HospitalSlot;

@Repository
public interface SlotRepository extends CrudRepository<HospitalSlot,Long> {

}
