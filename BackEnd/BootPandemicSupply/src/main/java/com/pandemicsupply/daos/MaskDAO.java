package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.FacilityMask;
import com.pandemicsupply.entities.Mask;

public interface MaskDAO {

	FacilityMask createFMAssociation(int fid, int mid);
	FacilityMask findFMByFacilityAndMask(int fid, int mid);
	List<FacilityMask> findFMByMask(int mid);
	FacilityMask updateFM(int fid, int mid, int quantity);
	Mask findMaskById(int mid);
	Mask createMask(Mask mask);
	Mask modifyMask(Mask mask);
	
}
