package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityTestKitId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "facility_id")
	private int facilityId;
	
	@Column(name = "test_id")
	private int testId;

	public FacilityTestKitId() {
		super();
	}

	public int getFacilityId() {
		return facilityId;
	}
	

	public FacilityTestKitId(int facilityId, int testId) {
		super();
		this.facilityId = facilityId;
		this.testId = testId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facilityId;
		result = prime * result + testId;
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
		FacilityTestKitId other = (FacilityTestKitId) obj;
		if (facilityId != other.facilityId)
			return false;
		if (testId != other.testId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityTestKitId [facilityId=");
		builder.append(facilityId);
		builder.append(", testId=");
		builder.append(testId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
