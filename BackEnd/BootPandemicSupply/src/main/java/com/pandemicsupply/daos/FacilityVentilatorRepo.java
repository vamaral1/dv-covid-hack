package com.pandemicsupply.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityVentilator;
import com.pandemicsupply.entities.Ventilator;

public interface FacilityVentilatorRepo extends JpaRepository<FacilityVentilator, Integer> {
	FacilityVentilator findByFacilityAndVentilator(Facility f, Ventilator ventilator);
	List<FacilityVentilator> findFacilityVentilatorByVentilator(Ventilator ventilator);
}

