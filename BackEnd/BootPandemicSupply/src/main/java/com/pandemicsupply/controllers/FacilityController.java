package com.pandemicsupply.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandemicsupply.daos.FacilityDAO;
import com.pandemicsupply.entities.Facility;

@RestController
@RequestMapping(path = "srsapi")
public class FacilityController {

	@Autowired
	private FacilityDAO facilityDao;
	
	@PostMapping(path = "facilities")
	public Facility createFacility(@RequestBody Facility facility) {
		return facilityDao.createFacility(facility);
	}
	
	@RequestMapping(path = "facilities/{fid}" )
	public Facility findById(@PathVariable int fid) {
		return facilityDao.findFacilityById(fid);
	}
	
	@PatchMapping(path = "facilities")
	public Facility updateFacility(@RequestBody Facility facility) {
		return facilityDao.updateFacility(facility);
	}
	
}
