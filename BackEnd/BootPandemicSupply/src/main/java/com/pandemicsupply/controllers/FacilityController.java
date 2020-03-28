package com.pandemicsupply.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandemicsupply.daos.FacilityDAO;
import com.pandemicsupply.entities.Facility;

@RestController
@RequestMapping(path = "api")
public class FacilityController {

	@Autowired
	private FacilityDAO facilityDao;
	
	@RequestMapping(path = "facilities/{id}" )
	public Facility findById(@PathVariable int id) {
		return facilityDao.findFacilityById(id);
	}
	
}
