package com.pandemicsupply.daos;

import com.pandemicsupply.entities.CleaningProduct;
import com.pandemicsupply.entities.FacilityCleaningProduct;

public interface CleaningProductDAO {
	
	FacilityCleaningProduct findFCPByFacilityAndCleaningProduct(int fid, int cpid);
	CleaningProduct findCleaningProductById(int cpid);

}
