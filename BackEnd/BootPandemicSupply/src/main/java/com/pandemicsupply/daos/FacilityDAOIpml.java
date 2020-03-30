package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Address;
import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.repositories.AddressRepo;
import com.pandemicsupply.repositories.FacilityRepository;

@Service
public class FacilityDAOIpml implements FacilityDAO {

	@Autowired
	private FacilityRepository facilityRepo;
	
	@Autowired
	private AddressRepo addressrepo;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Facility createFacility(Facility facility) {
		return facilityRepo.saveAndFlush(facility);
	}

	@Override
	public Facility findFacilityById(int id) {
		Optional<Facility> facility = facilityRepo.findById(id);
		if (facility.isPresent()) {
			return facility.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Facility> findAllFacilities() {
		return facilityRepo.findAll();
	}
	
	@Override
	public Facility updateFacility(Facility facility) {
		Optional<Facility> optionalFacility = facilityRepo.findById(facility.getId());

		if (optionalFacility.isPresent()) {
			Facility managedFacility = optionalFacility.get();
			managedFacility.setAddress(facility.getAddress());
			managedFacility.setName(facility.getName());
			return facilityRepo.saveAndFlush(facility);
		}

		return null;

	}

	@Override
	public Address findAddressByFacility(Facility facility) {
		return addressrepo.findByFacility(facility);
	}

	@Override
	public List<Facility> findByNameLike(String facilityName) {
		facilityName = "%" + facilityName + "%";
		System.err.println("Name in FacilityDAOImpl: " + facilityName);
		List<Facility> facilities = facilityRepo.findByNameLike(facilityName);
		for (Facility facility : facilities) {
			System.out.println(facility.getName());
		}
		return facilities;
	}

}
