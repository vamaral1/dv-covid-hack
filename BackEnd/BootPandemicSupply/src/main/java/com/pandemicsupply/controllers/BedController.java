package com.pandemicsupply.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pandemicsupply.daos.BedDAO;
import com.pandemicsupply.entities.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "srsapi")
public class BedController {
	
	@Autowired
	private BedDAO bDAO;
	
	// beds
	@GetMapping(path = "bed/{bid}")
	public Bed bedById(@PathVariable int bid) {
		return bDAO.findBedById(bid);
	}
	
	@PostMapping(path = "bed")
	public Bed newBed(@RequestBody Bed bed, HttpServletRequest req, HttpServletResponse resp) {
		bed = bDAO.createBed(bed);
		
		if (bed == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}
		return bed;
	}
	
	@PatchMapping(path = "bed")
	public Bed updateBed(@RequestBody Bed bed) {
		return bDAO.modifyBed(bed);
	}

}
