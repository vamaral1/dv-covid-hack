package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Address;
import com.pandemicsupply.entities.Facility;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	Address findByFacility (Facility facility);
}
