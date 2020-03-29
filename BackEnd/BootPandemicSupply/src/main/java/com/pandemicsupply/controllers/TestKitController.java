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

import com.pandemicsupply.daos.TestKitDAO;
import com.pandemicsupply.entities.FacilityTestKit;
import com.pandemicsupply.entities.TestKit;

@RestController
@RequestMapping(path = "srsapi")
public class TestKitController {

	@Autowired
	private TestKitDAO tdao;

	// test passed
	// FacilityTestKit - find by Facility and TestKit
	@GetMapping(path = "facilities/{fid}/testKit/{testId}")
	public FacilityTestKit findSingleFacilityTestKitByFacilityAndTestKit(@PathVariable int fid,
			@PathVariable int testId) {
		FacilityTestKit facTest = tdao.findFacilityTestKitByFacilityAndTestKit(fid, testId);

		if (facTest == null) {
			return tdao.createFacilityTestKitAssociation(fid, testId);
		}
		return facTest;
	}
	// test passed
	// FacilityTestKit - update qty
	@PatchMapping(path = "facilities/{fid}/testKit/{testId}/{quantity}")
	public FacilityTestKit updateFacilityTestKitInventoryQuantity(@PathVariable int fid, @PathVariable int testId, @PathVariable int quantity) {
		return tdao.updateFacilityTestKit(fid, testId, quantity);
	}

	// test passed
	// FacilityTestKit - find List of FacilityTestKit by TestKit
	@GetMapping(path = "testKit/{testId}/facilities")
	public List<FacilityTestKit> findFacilityTestKitListByTestKit(@PathVariable int testId) {
		return tdao.findFacilityTestKitListByTestKitId(testId);
	}

	// test passed
	// find test by id
	@GetMapping(path = "testKit/{testId}")
	public TestKit findTestKitById(@PathVariable int testId) {
		return tdao.findTestKitById(testId);
	}
	
	//test passed
	// create new test
	@PostMapping(path = "testKit")
	public TestKit createTestKit(@RequestBody TestKit testKit, HttpServletRequest req, HttpServletResponse resp) {
		TestKit newKit = tdao.createTestKit(testKit);

		if (newKit == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}

		return newKit;
	}

	// test passed
	// update existing test
	@PatchMapping(path = "testKit")
	public TestKit updateTestKit(@RequestBody TestKit testKit) {
		return tdao.modifyTestKit(testKit);
	}
}
