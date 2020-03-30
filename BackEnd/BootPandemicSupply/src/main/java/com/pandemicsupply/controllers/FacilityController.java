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

import com.pandemicsupply.daos.FacilityDAO;
import com.pandemicsupply.entities.Address;
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

	@RequestMapping(path = "facilities/{fid}")
	public Facility findById(@PathVariable int fid) {
		return facilityDao.findFacilityById(fid);
	}

	@PatchMapping(path = "facilities")
	public Facility updateFacility(@RequestBody Facility facility) {
		return facilityDao.updateFacility(facility);
	}

	// TEST FAIL
	// find list of Facilities by name
	@GetMapping(path = "facilities/{name}")
	public List<Facility> getFacilityListByName(@PathVariable String name, HttpServletRequest req,
			HttpServletResponse resp) {
		System.err.println("Name in Controller: " + name);
		List<Facility> facilityList = facilityDao.findByNameLike(name);
		if (facilityList == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}

		return facilityList;
	}

	// test pass
	// find Address by Facility
	@GetMapping(path = "facilities/{fid}/address")
	public Address findAddressByFacility(@PathVariable int fid, HttpServletRequest req, HttpServletResponse resp) {
		Facility foundFacility = facilityDao.findFacilityById(fid);
		Address foundAddress = null;
		if (foundFacility != null) {
			foundAddress = facilityDao.findAddressByFacility(foundFacility);
			resp.setStatus(202);
		} 
		else {
			resp.setStatus(404);
		}
		return foundAddress;
	}
}
