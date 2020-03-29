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

import com.pandemicsupply.daos.VentilatorDAO;
import com.pandemicsupply.entities.FacilityVentilator;
import com.pandemicsupply.entities.Ventilator;

@RestController
@RequestMapping(path = "srsapi")
public class VentilatorController {
	
	@Autowired
	private VentilatorDAO vdao;
	
	// TEST PASSED
	//FIND BY ID
	@GetMapping(path = "facilities/{fid}/ventilator/{ventId}")
	public FacilityVentilator findSingleFacVentByFacilityAndVentilator(@PathVariable int fid, @PathVariable int ventId) {
		FacilityVentilator facVent = vdao.findFacilityVentilatorByFacilityAndVentilator(fid, ventId);
		
		if (facVent == null) {
			return vdao.createFacilityVentilatorAssociation(fid, ventId);
		}
		return facVent;
	}
	
	// test passed
	//FIND LIST<FACILITYVENTILATOR> BY VENTILATOR
	@GetMapping(path = "ventilator/{ventId}/facilities")
	public List<FacilityVentilator> findListOfFacilityVentsByVentilator(@PathVariable int ventId){
		return vdao.findFacVentilatorByVentilator(vdao.findVentilatorById(ventId));
	}
	
	// test passed
	//UPDATE FACILITYVENTILATOR QTY
	@PatchMapping(path = "facilities/{fid}/ventilator/{ventId}/{quantity}")
	public FacilityVentilator updateFacVentInventoryQty(@PathVariable int fid, @PathVariable int ventId, @PathVariable int quantity) {
		return vdao.updateFacilityVentilator(fid, ventId, quantity);
	}
	
	
	//test passed
	//FIND VENTILATOR BY ID
	@GetMapping(path = "ventilator/{ventId}")
	public Ventilator getVentilatorById(@PathVariable int ventId) {
		return vdao.findVentilatorById(ventId);
	}
	
	// test passsed
	//CREATE NEW VENTILATOR
	@PostMapping(path = "ventilator")
	public Ventilator createVentilator(@RequestBody Ventilator ventilator, HttpServletRequest req, HttpServletResponse resp) {
		Ventilator newVent = vdao.createVentilator(ventilator);
		
		if (newVent == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}
		return newVent;
	}
	
	// test passed
	//UPDATE EXISTING VENTLATOR
	@PatchMapping(path = "ventilator")
	public Ventilator updateVentilator(@RequestBody Ventilator ventilator) {
		return vdao.modifyVentilator(ventilator);
	}

	
}
