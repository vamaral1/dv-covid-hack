package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityTestKit;
import com.pandemicsupply.entities.TestKit;
import com.pandemicsupply.repositories.FacilityRepository;
import com.pandemicsupply.repositories.FacilityTestKitRepo;
import com.pandemicsupply.repositories.TestKitRepo;

@Service
public class TestKitDAOImpl implements TestKitDAO {

	@Autowired
	private FacilityTestKitRepo ftestrepo;
	
	@Autowired
	private FacilityRepository frepo;
	
	@Autowired
	private TestKitRepo testrepo;
	
	@Override
	public FacilityTestKit createFacilityTestKitAssociation(int fid, int testId) {
		Optional<Facility> f = frepo.findById(fid);
		Optional<TestKit> kit = testrepo.findById(testId);
		if (f.isPresent() && kit.isPresent()) {
			FacilityTestKit fkit = new FacilityTestKit(f.get(),kit.get());
			return ftestrepo.saveAndFlush(fkit);
		}
		return null;
	}

	@Override
	public FacilityTestKit findFacilityTestKitByFacilityAndTestKit(int fid, int testId) {
		Optional<Facility> f = frepo.findById(fid);
		Optional<TestKit> kit = testrepo.findById(testId);
		if (f.isPresent() && kit.isPresent()) {
			FacilityTestKit fkit = ftestrepo.findByFacilityAndTestKit(f.get(), kit.get());
			if (fkit == null) {
				fkit = new FacilityTestKit(f.get(), kit.get());
				ftestrepo.saveAndFlush(fkit);
			}
			return fkit;
		}
		return null;
	}

	@Override
	public List<FacilityTestKit> findFacilityTestKitListByTestKitId(int testId) {
		Optional<TestKit> kit = testrepo.findById(testId);
		if (kit.isPresent()) {
			return ftestrepo.findByTestKit(kit.get());
		}
		return null;
	}

	@Override
	public FacilityTestKit updateFacilityTestKit(int fid, int testId, int quantity) {
		Optional<Facility> f = frepo.findById(fid);
		Optional<TestKit> kit = testrepo.findById(testId);
		if (f.isPresent() && kit.isPresent()) {
			FacilityTestKit fkit = ftestrepo.findByFacilityAndTestKit(f.get(), kit.get());
			if (fkit == null) {
				fkit = new FacilityTestKit(f.get(), kit.get());
			}
			fkit.setQuantity(quantity);
			return ftestrepo.save(fkit);
		}
		return null;
	}

	@Override
	public TestKit findTestKitById(int testId) {
		Optional<TestKit> kit = testrepo.findById(testId);
		if (kit.isPresent()) {
			return kit.get();
		}
		return null;
	}

	@Override
	public TestKit createTestKit(TestKit testKit) {
		return testrepo.saveAndFlush(testKit);
	}

	@Override
	public TestKit modifyTestKit(TestKit testKit) {
		Optional<TestKit> kitOpt = testrepo.findById(testKit.getId());
		if (kitOpt.isPresent()) {
			TestKit managedKit = kitOpt.get();
			managedKit.setType(testKit.getType());
			managedKit.setUPC(testKit.getUPC());
			return testrepo.saveAndFlush(managedKit);
		}
		return null;
	}

}
