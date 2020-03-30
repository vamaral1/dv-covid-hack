package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityMask;
import com.pandemicsupply.entities.Mask;
import com.pandemicsupply.repositories.FacilityMaskRepo;
import com.pandemicsupply.repositories.FacilityRepository;
import com.pandemicsupply.repositories.MaskRepo;

@Service
public class MaskDAOImpl implements MaskDAO {
	
	@Autowired
	private FacilityRepository fRepo;
	
	@Autowired
	private MaskRepo mRepo;
	
	@Autowired FacilityMaskRepo fmRepo;

	@Override
	public FacilityMask createFMAssociation(int fid, int mid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Mask> m = mRepo.findById(mid);
		
		if (f.isPresent() && m.isPresent()) {
			FacilityMask fm = new FacilityMask(f.get(), m.get());
			
			return fmRepo.saveAndFlush(fm);
		}
		
		return null;
	}

	@Override
	public FacilityMask findFMByFacilityAndMask(int fid, int mid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Mask> m = mRepo.findById(mid);
		
		if (f.isPresent() && m.isPresent()) {
			FacilityMask fm = fmRepo.findByFacilityAndMask(f.get(), m.get());
			if (fm == null) {
				fm = new FacilityMask(f.get(), m.get());
				fmRepo.saveAndFlush(fm);
			}
			return fm;
		}
		
		return null;
	}
	
	@Override
	public List<FacilityMask> findFMByFacility(int fid) {
		Optional<Facility> optFacility = fRepo.findById(fid);
		if (optFacility.isPresent()) {
			return fmRepo.findByFacility(optFacility.get());
		}
		return null;
	}
	
	@Override
	public List<FacilityMask> findFMByMask(int mid) {
		Optional<Mask> mask = mRepo.findById(mid);
		if (mask.isPresent()) {
			return fmRepo.findByMask(mask.get());
		}
		return null;
	}

	@Override
	public FacilityMask updateFM(int fid, int mid, int quantity) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Mask> m = mRepo.findById(mid);
		
		if (f.isPresent() && m.isPresent()) {
			FacilityMask fm = fmRepo.findByFacilityAndMask(f.get(), m.get());
			if (fm == null) {
				fm = new FacilityMask(f.get(), m.get());
			}
			fm.setQuantity(quantity);
			return fmRepo.saveAndFlush(fm);
		}
		
		return null;
	}
	
	@Override
	public List<Mask> findAllMasks() {
		return mRepo.findAll();
	}

	@Override
	public Mask findMaskById(int mid) {
		Optional<Mask> mask = mRepo.findById(mid);
		
		if (mask.isPresent()) {
			return mask.get();
		}
		
		return null;
	}

	@Override
	public Mask createMask(Mask mask) {
		return mRepo.saveAndFlush(mask);
	}

	@Override
	public Mask modifyMask(Mask mask) {
		Optional<Mask> optionalMask = mRepo.findById(mask.getId());
		
		if (optionalMask.isPresent()) {
			Mask managedMask = optionalMask.get();
			managedMask.setImprovised(mask.getImprovised());
			managedMask.setName(mask.getName());
			managedMask.setRating(mask.getRating());
			managedMask.setReusable(mask.getReusable());
			managedMask.setType(mask.getType());
			managedMask.setUPC(mask.getUPC());
			return mRepo.saveAndFlush(managedMask);
		}
		return null;
	}

}
