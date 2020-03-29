package com.pandemicsupply.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityTestKit;
import com.pandemicsupply.entities.TestKit;

public interface FacilityTestKitRepo extends JpaRepository<FacilityTestKit, Integer> {
	FacilityTestKit findByFacilityAndTestKit(Facility f, TestKit testKit);
	List<FacilityTestKit> findByTestKit(TestKit testKit);
}
