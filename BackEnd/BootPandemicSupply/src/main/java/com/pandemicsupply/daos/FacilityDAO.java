package com.pandemicsupply.daos;

import com.pandemicsupply.entities.Facility;

public interface FacilityDAO {
	
	Facility createFacility(Facility facility);
	Facility findFacilityById(int id);
	Facility updateFacility(Facility facility);

}
