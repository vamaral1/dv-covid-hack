package com.pandemicsupply.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	List<Facility> findByNameLike(String facilityName);
}
