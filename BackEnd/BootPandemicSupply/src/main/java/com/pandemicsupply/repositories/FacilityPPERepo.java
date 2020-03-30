package com.pandemicsupply.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityPPE;
import com.pandemicsupply.entities.PersonalProtectiveEquipment;

public interface FacilityPPERepo extends JpaRepository<FacilityPPE, Integer> {
	FacilityPPE findByFacilityAndPpe(Facility f, PersonalProtectiveEquipment ppe);
	List<FacilityPPE> findFacilityPPEByFacility(Facility f);
	List<FacilityPPE> findFacilityPPEByPpe(PersonalProtectiveEquipment ppe);
	
}
