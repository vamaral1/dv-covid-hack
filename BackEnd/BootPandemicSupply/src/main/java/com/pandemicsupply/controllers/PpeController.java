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

import com.pandemicsupply.daos.PersonalProtectiveEquipmentDAO;
import com.pandemicsupply.entities.FacilityPPE;
import com.pandemicsupply.entities.PersonalProtectiveEquipment;

@RestController
@RequestMapping(path = "srsapi")
public class PpeController {

	@Autowired
	private PersonalProtectiveEquipmentDAO ppeDAO;
	
	//TEST PASSED
	// FIND FACILITY PPE BY FACILITY AND PPE
	@GetMapping(path = "facilities/{fid}/ppe/{ppeId}")
	public FacilityPPE findSingleFacPPEByFacilityAndPPE(@PathVariable int fid, @PathVariable int ppeId) {
		FacilityPPE facPpe = ppeDAO.findFacilityPPEByFacilityAndPPE(fid, ppeId);

		if (facPpe == null) {
			return ppeDAO.createFacilityPPEAssociation(fid, ppeId);
		}
		return facPpe;
	}
	
	// Facility PPE inventory methods
	
	// NOT TESTED
	// list of inventories of PPE types at a facility
	@GetMapping(path = "facilities/{fid}/ppe")
	public List<FacilityPPE> findAllPPEInventoryByFacility(@PathVariable int fid) {
		return ppeDAO.findFacPPEByFacilityId(fid);
	}
	
	//TEST PASS
	// find List<FacilityPPE> by PPE
	// from this List<FacilityPPE>, we can determine the List<Facility> and the List<Integer>, which represents the quantity
	// Note:  for front end, maybe make a Map<Facility, Integer> where Key = Facility and Integer = quantity
	@GetMapping(path = "ppe/{ppeId}/facilities")
	public List<FacilityPPE> findListOfFacilityPPEsByPPE(@PathVariable int ppeId){
		return ppeDAO.findFacPPEByPPE(ppeDAO.findPPEById(ppeId));
	}
	// TEST PASSED (FOR TAKING OUT INVENTORY, {quantity} must be a negative number
	// update FacilityPPE qty
	@PatchMapping(path = "facilities/{fid}/ppe/{ppeId}/{quantity}")
	public FacilityPPE updateFacPPEInventory(@PathVariable int fid, @PathVariable int ppeId,
			@PathVariable int quantity) {
		return ppeDAO.updateFacilityPPE(fid, ppeId, quantity);
	}
	// TEST PASSED
	//find ppe by id
	@GetMapping(path = "ppe/{pid}")
	public PersonalProtectiveEquipment getPPEById(@PathVariable int pid) {
		return ppeDAO.findPPEById(pid);
	}
	
	// find all ppes
	@GetMapping(path = "ppe")
	public List<PersonalProtectiveEquipment> findAllPPE() {
		return ppeDAO.findAllPPE();
	}
	
	//TEST PASSED
	// create PPE
	@PostMapping(path = "ppe")
	public PersonalProtectiveEquipment createPPE(@RequestBody PersonalProtectiveEquipment ppe,HttpServletRequest req, HttpServletResponse resp) {
		PersonalProtectiveEquipment newPpe = ppeDAO.createPPE(ppe);
		
		if (newPpe == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}
		
		return newPpe;
	}
	
	// TEST PASSED
	// update PPE
	@PatchMapping(path = "ppe")
	public PersonalProtectiveEquipment updatePPE(@RequestBody PersonalProtectiveEquipment ppe) {
		return ppeDAO.modifyPPE(ppe);
	}
}
