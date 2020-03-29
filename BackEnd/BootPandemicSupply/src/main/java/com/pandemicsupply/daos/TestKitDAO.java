package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.TestKit;
import com.pandemicsupply.entities.FacilityTestKit;

public interface TestKitDAO {

	FacilityTestKit createFacilityTestKitAssociation(int fid, int testId);

	FacilityTestKit findFacilityTestKitByFacilityAndTestKit(int fid, int testId);

	List<FacilityTestKit> findFacilityTestKitListByTestKitId(int testId);

	FacilityTestKit updateFacilityTestKit(int fid, int testId, int quantity);

	TestKit findTestKitById(int testId);

	TestKit createTestKit(TestKit testKit);

	TestKit modifyTestKit(TestKit testKit);

}
