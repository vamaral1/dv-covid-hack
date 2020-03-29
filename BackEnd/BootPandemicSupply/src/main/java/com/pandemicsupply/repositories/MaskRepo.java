package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Mask;

public interface MaskRepo extends JpaRepository<Mask, Integer> {
	
}
