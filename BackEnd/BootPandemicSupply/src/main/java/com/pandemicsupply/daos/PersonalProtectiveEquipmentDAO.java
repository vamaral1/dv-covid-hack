package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.FacilityPPE;
import com.pandemicsupply.entities.PersonalProtectiveEquipment;

public interface PersonalProtectiveEquipmentDAO {

	FacilityPPE createFacilityPPEAssociation (int fid, int ppeId);
	FacilityPPE findFacilityPPEByFacilityAndPPE(int fid, int ppeId);
	FacilityPPE updateFacilityPPE(int fid, int ppeId, int quantity);
	List<FacilityPPE> findFacPPEByPPE(PersonalProtectiveEquipment ppe);
	PersonalProtectiveEquipment findPPEById(int cpid);
	PersonalProtectiveEquipment createPPE(PersonalProtectiveEquipment ppe);
	PersonalProtectiveEquipment modifyPPE(PersonalProtectiveEquipment ppe);
}
