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

class TestKitTest {
	static EntityManagerFactory emf;
	private EntityManager em;
	private TestKit tk;
	private FacilityTestKit ftk;
	
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
		tk = em.find(TestKit.class, 1);
		FacilityTestKitId ftkId = new FacilityTestKitId(1,1);
		ftkId.setFacilityId(1);
		ftkId.setFacilityId(1);
		ftk = em.find(FacilityTestKit.class, ftkId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		tk = null;
		ftk = null;
	}

	@Test
	@DisplayName("test testkit has the first testkit")
	void test() {
		assertNotNull(tk);
		assertEquals("influenza", tk.getType());
		assertEquals("123-45678", tk.getUPC());
	}

}
