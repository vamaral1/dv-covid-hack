package com.pandemicsupply.daos;

import com.pandemicsupply.entities.Bed;

public interface BedDAO {

	Bed findBedById(int bid);
	Bed createBed(Bed bed);
	Bed modifyBed(Bed bed);
	
}
