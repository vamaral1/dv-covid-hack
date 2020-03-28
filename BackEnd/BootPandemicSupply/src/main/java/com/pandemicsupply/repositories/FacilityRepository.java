package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

}
