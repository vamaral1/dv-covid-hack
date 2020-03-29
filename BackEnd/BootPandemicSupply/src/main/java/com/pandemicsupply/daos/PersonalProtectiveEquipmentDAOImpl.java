package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityPPE;
import com.pandemicsupply.entities.PersonalProtectiveEquipment;
import com.pandemicsupply.repositories.FacilityPPERepo;
import com.pandemicsupply.repositories.FacilityRepository;
import com.pandemicsupply.repositories.PersonalProtectiveEquipmentRepo;

@Service
public class PersonalProtectiveEquipmentDAOImpl implements PersonalProtectiveEquipmentDAO {

	@Autowired
	private FacilityRepository fRepo;

	@Autowired
	private PersonalProtectiveEquipmentRepo ppeRepo;

	@Autowired
	private FacilityPPERepo fppeRepo;

	@Override
	public FacilityPPE createFacilityPPEAssociation(int fid, int ppeId) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<PersonalProtectiveEquipment> ppe = ppeRepo.findById(ppeId);
		if (fac.isPresent() && ppe.isPresent()) {
			FacilityPPE facPpe = new FacilityPPE(fac.get(), ppe.get());
			return facPpe;
		}
		return null;
	}

	// get list of FacilityPPE (and Facility) by PPE
	// in front end, you can use each FacilityPPE in the List<FacilityPPE> to grab the Facility object and the quantity that Facility has.
	@Override
	public List<FacilityPPE> findFacPPEByPPE(PersonalProtectiveEquipment ppe) {
		return fppeRepo.findFacilityPPEByPpe(ppe);
	}

	@Override
	public FacilityPPE findFacilityPPEByFacilityAndPPE(int fid, int ppeId) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<PersonalProtectiveEquipment> ppe = ppeRepo.findById(ppeId);

		if (fac.isPresent() && ppe.isPresent()) {
			return fppeRepo.findByFacilityAndPpe(fac.get(), ppe.get());
		}
		return null;
	}
	
	
	@Override
	public FacilityPPE updateFacilityPPE(int fid, int ppeId, int quantity) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<PersonalProtectiveEquipment> ppe = ppeRepo.findById(ppeId);

		if (fac.isPresent() && ppe.isPresent()) {
			FacilityPPE facPpe = fppeRepo.findByFacilityAndPpe(fac.get(), ppe.get());
			if (facPpe == null) {
				facPpe = new FacilityPPE(fac.get(), ppe.get());
			}
			facPpe.setQuantity(quantity);
			return fppeRepo.saveAndFlush(facPpe);
		}
		return null;
	}

	@Override
	public PersonalProtectiveEquipment findPPEById(int ppeId) {
		Optional<PersonalProtectiveEquipment> optPpe = ppeRepo.findById(ppeId);
		if (optPpe.isPresent()) {
			return optPpe.get();
		}
		return null;
	}

	@Override
	public PersonalProtectiveEquipment createPPE(PersonalProtectiveEquipment ppe) {
		return ppeRepo.saveAndFlush(ppe);
	}

	@Override
	public PersonalProtectiveEquipment modifyPPE(PersonalProtectiveEquipment ppe) {
		Optional<PersonalProtectiveEquipment> optPpe = ppeRepo.findById(ppe.getId());
		if (optPpe.isPresent()) {
			PersonalProtectiveEquipment managedPpe = optPpe.get();
			managedPpe.setImprovised(ppe.isImprovised());
			managedPpe.setName(ppe.getName());
			managedPpe.setPowdered(ppe.isPowdered());
			managedPpe.setReusable(ppe.isReusable());
			managedPpe.setSize(ppe.getSize());
			managedPpe.setType(ppe.getType());
			managedPpe.setUPC(ppe.getUPC());
			return ppeRepo.saveAndFlush(managedPpe);
		}
		return null;
	}

}
