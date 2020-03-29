package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityVentilator;
import com.pandemicsupply.entities.Ventilator;
import com.pandemicsupply.repositories.FacilityRepository;
import com.pandemicsupply.repositories.VentilatorRepo;

@Service
public class VentilatorDAOImpl implements VentilatorDAO {

	@Autowired
	private FacilityRepository fRepo;

	@Autowired
	private VentilatorRepo ventRepo;

	@Autowired
	private FacilityVentilatorRepo fvRepo;
	
	@Override
	public FacilityVentilator createFacilityVentilatorAssociation(int fid, int ventId) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<Ventilator> ventOpt = ventRepo.findById(ventId);
		if (fac.isPresent() && ventOpt.isPresent()) {
			FacilityVentilator facVent = new FacilityVentilator(ventOpt.get(), fac.get());
			return facVent;
		}
		return null;
	}

	@Override
	public FacilityVentilator findFacilityVentilatorByFacilityAndVentilator(int fid, int ventId) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<Ventilator> ventOpt = ventRepo.findById(ventId);
		if (fac.isPresent() && ventOpt.isPresent()) {
			return fvRepo.findByFacilityAndVentilator(fac.get(), ventOpt.get());
		}
		return null;
	}

	@Override
	public FacilityVentilator updateFacilityVentilator(int fid, int ventId, int quantity) {
		Optional<Facility> fac = fRepo.findById(fid);
		Optional<Ventilator> ventOpt = ventRepo.findById(ventId);
		if (fac.isPresent() && ventOpt.isPresent()) {
			FacilityVentilator facVent = fvRepo.findByFacilityAndVentilator(fac.get(), ventOpt.get());
			if (facVent == null) {
				facVent = new FacilityVentilator(ventOpt.get(), fac.get());
			}
			facVent.setQuantity(quantity);
			return fvRepo.saveAndFlush(facVent);
		}
		return null;
	}
	// get list of FacilityVentilator (and Facility) by Ventilator
	// in front end, you can use each FacilityVentilator in the List<FacilityVentilator> to grab the Facility object 
	// and the quantity that Facility has.
	@Override
	public List<FacilityVentilator> findFacVentilatorByVentilator(Ventilator ventilator) {
		return fvRepo.findFacilityVentilatorByVentilator(ventilator);
	}

	@Override
	public Ventilator findVentilatorById(int ventId) {
		Optional<Ventilator> ventOpt = ventRepo.findById(ventId);
		if (ventOpt.isPresent()) {
			return ventOpt.get();
		}
		return null;
	}

	@Override
	public Ventilator createVentilator(Ventilator ventilator) {
		return ventRepo.saveAndFlush(ventilator);
	}

	@Override
	public Ventilator modifyVentilator(Ventilator ventilator) {
		Optional<Ventilator> optVent = ventRepo.findById(ventilator.getId());
		if (optVent.isPresent()) {
			Ventilator managedVent = optVent.get();
			managedVent.setMake(ventilator.getMake());
			managedVent.setModel(ventilator.getModel());
			managedVent.setInvasive(ventilator.isInvasive());
			managedVent.setUPC(ventilator.getUPC());
			return ventRepo.saveAndFlush(managedVent);
		}		return null;
	}

}
