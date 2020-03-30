package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facility_test_kit")
public class FacilityTestKit {
	
	@EmbeddedId
	private FacilityTestKitId id = new FacilityTestKitId();

	private int quantity;
	
	@JsonIgnoreProperties({"facilityCleaningProducts", "masks", "ventilators", "ppes", "testKits", "facilityRoomsInventory"})
	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	@MapsId(value = "testId")
	private TestKit testKit;

	public FacilityTestKit() {
		super();
	}

	public FacilityTestKit(int quantity, Facility facility, TestKit testKit) {
		super();
		this.quantity = quantity;
		this.facility = facility;
		this.testKit = testKit;
	}

	public FacilityTestKit(Facility facility, TestKit testKit) {
		super();
		this.facility = facility;
		this.testKit = testKit;
	}

	public FacilityTestKitId getId() {
		return id;
	}

	public void setId(FacilityTestKitId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity += quantity;
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TestKit getTestKit() {
		return testKit;
	}

	public void setTestKit(TestKit testKit) {
		this.testKit = testKit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilityTestKit other = (FacilityTestKit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityTestKit [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", facility=");
		builder.append(facility);
		builder.append(", testKit=");
		builder.append(testKit);
		builder.append("]");
		return builder.toString();
	}
	
	
}
