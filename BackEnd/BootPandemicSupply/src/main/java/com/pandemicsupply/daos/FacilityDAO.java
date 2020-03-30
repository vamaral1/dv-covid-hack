package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.Address;
import com.pandemicsupply.entities.Facility;

public interface FacilityDAO {
	
	Facility createFacility(Facility facility);
	Facility findFacilityById(int id);
	List<Facility> findAllFacilities();
	Facility updateFacility(Facility facility);
	
	Address findAddressByFacility(Facility facility);
	
	List<Facility> findByNameLike(String facilityName);
}
