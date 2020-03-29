package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.CleaningProduct;

public interface CleaningProductRepo extends JpaRepository<CleaningProduct, Integer>{
	
}
