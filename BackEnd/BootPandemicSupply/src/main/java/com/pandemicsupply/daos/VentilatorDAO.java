package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.FacilityVentilator;
import com.pandemicsupply.entities.Ventilator;

public interface VentilatorDAO {

	FacilityVentilator createFacilityVentilatorAssociation(int fid, int ventId);

	FacilityVentilator findFacilityVentilatorByFacilityAndVentilator(int fid, int ventId);

	FacilityVentilator updateFacilityVentilator(int fid, int ppeId, int quantity);

	List<FacilityVentilator> findFacVentilatorByVentilator(Ventilator ventilator);

	Ventilator findVentilatorById(int ventid);

	Ventilator createVentilator(Ventilator ventilator);

	Ventilator modifyVentilator(Ventilator ventilator);
}
