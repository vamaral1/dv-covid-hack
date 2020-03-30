package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.FacilityCleaningProduct;

public interface CleaningProductDAO {
	
	FacilityCleaningProduct createFCPAssociation(int fid, int cpid);
	FacilityCleaningProduct findFCPByFacilityAndCleaningProduct(int fid, int cpid);
	List<FacilityCleaningProduct> findFCPByFacilityId(int fid);
	List<FacilityCleaningProduct> findFCPByCleaningProductId(int cpid);
	FacilityCleaningProduct updateFCP(int fid, int cpid, int quantity);
	List<CleaningProduct> findAllCleaningProducts();
	CleaningProduct findCleaningProductById(int cpid);
	CleaningProduct createCleaningProduct(CleaningProduct cp);
	CleaningProduct modifyCleaningProduct(CleaningProduct cp);

}
