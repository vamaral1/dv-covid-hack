package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityCleaningProduct;

public interface FacilityCleaningProductRepository extends JpaRepository<FacilityCleaningProduct, Integer> {
	FacilityCleaningProduct findByFacilityAndCleaningProduct(Facility f, CleaningProduct cp);
}
