package com.pandemicsupply.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VentilatorTest {

	static EntityManagerFactory emf;
	private EntityManager em;
	private Ventilator vent;
	private FacilityVentilator facVent;

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
		vent = em.find(Ventilator.class, 1);
		FacilityVentilatorId facVentId = new FacilityVentilatorId(1, 1);
		facVentId.setFacilityId(1);
		facVentId.setVentilatorId(1);
		facVent = em.find(FacilityVentilator.class, facVentId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		vent = null;
		facVent = null;
	}

	@Test
	void test_ventilator() {
		assertNotNull(vent);
		assertEquals("Respironics", vent.getMake());
		assertEquals("V200", vent.getModel());
	}
	
	@Test
	void test_facility_ventilator() {
		assertNotNull(facVent);
		assertEquals(20, facVent.getQuantity());
	}


}
