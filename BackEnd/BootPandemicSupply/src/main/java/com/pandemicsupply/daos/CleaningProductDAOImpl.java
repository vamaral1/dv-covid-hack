package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityCleaningProduct;
import com.pandemicsupply.entities.FacilityCleaningProductId;
import com.pandemicsupply.repositories.CleaningProductRepo;
import com.pandemicsupply.repositories.FacilityCleaningProductRepository;
import com.pandemicsupply.repositories.FacilityRepository;

@Service
public class CleaningProductDAOImpl implements CleaningProductDAO {

	@Autowired
	private FacilityCleaningProductRepository fcpRepo;

	@Autowired
	private FacilityRepository fRepo;

	@Autowired
	private CleaningProductRepo cpRepo;
	
	@Override
	public FacilityCleaningProduct createFCPAssociation(int fid, int cpid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (f.isPresent() && cp.isPresent()) {
			FacilityCleaningProduct fcp = new FacilityCleaningProduct(f.get(), cp.get());
			return fcpRepo.saveAndFlush(fcp);
		}
		return null;
	}

	@Override
	public FacilityCleaningProduct findFCPByFacilityAndCleaningProduct(int fid, int cpid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (f.isPresent() && cp.isPresent()) {
			FacilityCleaningProduct fcp = fcpRepo.findByFacilityAndCleaningProduct(f.get(), cp.get());
			if (fcp == null) {
				fcp = new FacilityCleaningProduct(f.get(), cp.get());
				fcpRepo.saveAndFlush(fcp);
			}
			return fcp;
		}
		return null;
	}
	
	@Override
	public List<FacilityCleaningProduct> findFCPByCleaningProductId(int cpid) {
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (cp.isPresent()) {
			return fcpRepo.findByCleaningProduct(cp.get());
		}
		return null;
	}

	@Override
	public FacilityCleaningProduct updateFCP(int fid, int cpid, int quantity) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (f.isPresent() && cp.isPresent()) {
			FacilityCleaningProduct fcp = fcpRepo.findByFacilityAndCleaningProduct(f.get(), cp.get());
			if (fcp == null) {
				fcp = new FacilityCleaningProduct(f.get(), cp.get());
			}
			fcp.setQuantity(quantity);
			return fcpRepo.saveAndFlush(fcp);
		}
		return null;
	}
	
	@Override
	public CleaningProduct findCleaningProductById(int cpid) {
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (cp.isPresent()) {
			return cp.get();
		}
		return null;
	}


	@Override
	public CleaningProduct createCleaningProduct(CleaningProduct cp) {
		return cpRepo.saveAndFlush(cp);
	}

	@Override
	public CleaningProduct modifyCleaningProduct(CleaningProduct cp) {
		Optional<CleaningProduct> optionalCP = cpRepo.findById(cp.getId());
		if (optionalCP.isPresent()) {
			CleaningProduct managedCP = optionalCP.get();
			managedCP.setAgent(cp.getAgent());
			managedCP.setConcentration(cp.getConcentration());
			managedCP.setName(cp.getName());
			managedCP.setUPC(cp.getUPC());
			managedCP.setVolume(cp.getVolume());
			return cpRepo.saveAndFlush(managedCP);
		}
		return null;
	}

}
