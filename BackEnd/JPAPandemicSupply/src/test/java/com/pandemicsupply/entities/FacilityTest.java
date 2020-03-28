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

class FacilityTest {
	
	static EntityManagerFactory emf;
	private EntityManager em;
	private Facility facility;

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
		facility = em.find(Facility.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		facility = null;
	}

	@Test
	@DisplayName("test hospital has name")
	void test_hospital_name() {
		assertNotNull(facility);
		assertEquals("Swedish Hospital", facility.getName());
	}

}
