package com.pandemicsupply.daos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityCleaningProduct;
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
	public FacilityCleaningProduct findFCPByFacilityAndCleaningProduct(int fid, int cpid) {
		// TODO Auto-generated method stub
		Optional<Facility> f = fRepo.findById(fid);
		Optional<CleaningProduct> cp = cpRepo.findById(cpid);
		if (f.isPresent() && cp.isPresent()) {
			return fcpRepo.findByFacilityAndCleaningProduct(f.get(), cp.get());
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

}
