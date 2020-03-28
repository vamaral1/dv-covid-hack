package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityMaskId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "facility_id")
	private int facilityId;
	
	@Column(name = "mask_id")
	private int maskId;

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getMaskId() {
		return maskId;
	}

	public void setMaskId(int maskId) {
		this.maskId = maskId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facilityId;
		result = prime * result + maskId;
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
		FacilityMaskId other = (FacilityMaskId) obj;
		if (facilityId != other.facilityId)
			return false;
		if (maskId != other.maskId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityMaskId [facilityId=");
		builder.append(facilityId);
		builder.append(", maskId=");
		builder.append(maskId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
