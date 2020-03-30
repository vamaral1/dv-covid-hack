package com.pandemicsupply.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityMask;
import com.pandemicsupply.entities.Mask;

public interface FacilityMaskRepo extends JpaRepository<FacilityMask, Integer> {
	FacilityMask findByFacilityAndMask(Facility facility, Mask mask);
	List<FacilityMask> findByFacility(Facility facility);
	List<FacilityMask> findByMask(Mask mask);
}
