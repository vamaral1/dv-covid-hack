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

import com.pandemicsupply.daos.MaskDAO;
import com.pandemicsupply.entities.FacilityMask;
import com.pandemicsupply.entities.Mask;

@RestController
@RequestMapping(path = "srsapi")
public class MaskController {
	
	@Autowired
	private MaskDAO mDAO;
	
	// masks
	@GetMapping(path = "masks/{mid}")
	public Mask maskById(@PathVariable int mid) {
		return mDAO.findMaskById(mid);
	}
	
	@PostMapping(path = "masks")
	public Mask newMask(@RequestBody Mask mask, HttpServletRequest req, HttpServletResponse resp) {
		mask = mDAO.createMask(mask);
		
		if (mask == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}
		return mask;
	}
	
	@PatchMapping(path = "masks")
	public Mask updateMask(@RequestBody Mask mask) {
		return mDAO.modifyMask(mask);
	}
	
	
	// facility mask inventory
	@GetMapping(path = "facilities/{fid}/masks/{mid}")
	public FacilityMask facilitySingleMaskInventory(@PathVariable int fid, @PathVariable int mid) {
		FacilityMask fm = mDAO.findFMByFacilityAndMask(fid, mid);
		
		if (fm == null) {
			return mDAO.createFMAssociation(fid, mid);
		}
		
		return fm;
	}
	
	@GetMapping(path = "facilities/masks/{mid}")
	public List<FacilityMask> findFacilitiesByMask(@PathVariable int mid) {
		return mDAO.findFMByMask(mid);
	}
	
	@PatchMapping(path = "facilities/{fid}/masks/{mid}/{quantity}")
	public FacilityMask updateFacilityMaskInventory(@PathVariable int fid, @PathVariable int mid, @PathVariable int quantity) {
		return mDAO.updateFM(fid, mid, quantity);
	}

}
