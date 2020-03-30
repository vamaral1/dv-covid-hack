package com.pandemicsupply.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// cleaning product creation, updating
	
	// single cp by id
	@GetMapping(path = "cleaningProducts/{cpid}")
	public CleaningProduct findSingleCleaningProductById(@PathVariable int cpid) {
		return cpDAO.findCleaningProductById(cpid);
	}
	
	// all available cleaning products database-wide
	@GetMapping(path = "cleaningProducts")
	public List<CleaningProduct> findAllCleaningProducts() {
		return cpDAO.findAllCleaningProducts();
	}

	// create new cp
	@PostMapping(path = "cleaningProducts")
	public CleaningProduct createCleaningProduct(@RequestBody CleaningProduct cp, HttpServletRequest req,
			HttpServletResponse resp) {
		cp = cpDAO.createCleaningProduct(cp);

		if (cp == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}

		return cp;
	}

	// update cp
	@PatchMapping(path = "cleaningProducts")
	public CleaningProduct updateCleaningProduct(@RequestBody CleaningProduct cp) {
		return cpDAO.modifyCleaningProduct(cp);
	}

	// facility cleaning product inventory mappings - find, update quantity

	// inventory for single CP at a facility
	@GetMapping(path = "facilities/{fid}/cleaningProducts/{cpid}")
	public FacilityCleaningProduct findSingleFCRByFacilityAndCleaningProduct(@PathVariable int fid,
			@PathVariable int cpid) {
		FacilityCleaningProduct fcp = cpDAO.findFCPByFacilityAndCleaningProduct(fid, cpid);

		if (fcp == null) {
			return cpDAO.createFCPAssociation(fid, cpid);
		}

		return fcp;
	}
	
	// untested
	// list of inventories of all CP types at a facility
	@GetMapping(path = "facilities/{fid}/cleaningProducts")
	public List<FacilityCleaningProduct> findAllAvailableCPsByFacility(@PathVariable int fid){
		return cpDAO.findFCPByFacilityId(fid);
	}

	// list of facility inventories of a given CP type
	@GetMapping(path = "facilities/cleaningProducts/{cpid}")
	public List<FacilityCleaningProduct> findFacilitiesByCleaningProduct(@PathVariable int cpid) {
		return cpDAO.findFCPByCleaningProductId(cpid);
	}

	// update the CP inventory for a specific facility, with a quantity
	@PatchMapping(path = "facilities/{fid}/cleaningProducts/{cpid}/{quantity}")
	public FacilityCleaningProduct updateFacilityCleaningProductInventory(@PathVariable int fid, @PathVariable int cpid,
			@PathVariable int quantity) {
		return cpDAO.updateFCP(fid, cpid, quantity);
	}

}
