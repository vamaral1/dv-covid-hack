package com.pandemicsupply.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CleaningProductTest {
	
	static EntityManagerFactory emf;
	private EntityManager em;
	private CleaningProduct cp;
	private FacilityCleaningProduct fcp;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("PandemicSupplyPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		cp = em.find(CleaningProduct.class, 1);
		FacilityCleaningProductId fcpid = new FacilityCleaningProductId();
		fcpid.setFacilityId(1);
		fcpid.setCleaningProductId(1);
		fcp = em.find(FacilityCleaningProduct.class, fcpid);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cp = null;
		fcp = null;
	}

	@Test
	@DisplayName("test cleaning product has the first product")
	void test() {
		assertNotNull(cp);
		assertEquals("Giddy up, Giddy up", cp.getName());
		assertEquals(0.98, cp.getConcentration(), 0.001);
	}
	
	@Test
	@DisplayName("test facility cleaning product exists")
	void test_facility_cleaning_product() {
		assertNotNull(fcp);
		assertEquals(42, fcp.getQuantity());
	}

}
