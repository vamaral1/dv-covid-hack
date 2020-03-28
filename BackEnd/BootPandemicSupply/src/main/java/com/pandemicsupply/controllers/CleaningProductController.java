package com.pandemicsupply.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandemicsupply.daos.CleaningProductDAO;
import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.FacilityCleaningProduct;

@RestController
@RequestMapping(path = "srsapi")
public class CleaningProductController {
	
	@Autowired
	private CleaningProductDAO cpDAO;
	
	@RequestMapping(path = "facilities/{fid}/cleaningProducts/{cpid}")
	public FacilityCleaningProduct findSingleFCRByFacilityAndCleaningProduct(@PathVariable int fid, @PathVariable int cpid) {
		return cpDAO.findFCPByFacilityAndCleaningProduct(fid, cpid); 
	}
	
	@RequestMapping(path = "cleaningProducts/{cpid}")
	public CleaningProduct findSingleCleaningProductById(@PathVariable int cpid) {
		return cpDAO.findCleaningProductById(cpid);
	}

}
