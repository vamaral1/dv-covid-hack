package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityCleaningProductId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "facility_id")
	private int facilityId;
	
	@Column(name = "cleaning_product_id")
	private int cleaningProductId;
	
	public FacilityCleaningProductId() {}
	
	public FacilityCleaningProductId(int facilityId, int cleaningProductId) {
		super();
		this.facilityId = facilityId;
		this.cleaningProductId = cleaningProductId;
	}

	public int getFacilityId() {
		return facilityId;
	}
	
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getCleaningProductId() {
		return cleaningProductId;
	}

	public void setCleaningProductId(int cleaningProductId) {
		this.cleaningProductId = cleaningProductId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cleaningProductId;
		result = prime * result + facilityId;
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
		FacilityCleaningProductId other = (FacilityCleaningProductId) obj;
		if (cleaningProductId != other.cleaningProductId)
			return false;
		if (facilityId != other.facilityId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityCleaningProductId [facilityId=");
		builder.append(facilityId);
		builder.append(", cleaningProductId=");
		builder.append(cleaningProductId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
