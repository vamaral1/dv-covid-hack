package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityPPEId implements Serializable{

	//fields
	private static final long serialVersionUID = 1L;
	
	@Column(name = "facility_id")
	private int facilityId;
	
	@Column(name = "ppe_id")
	private int ppeId;

	//CTORS
	public FacilityPPEId() {
		super();
	}

	public FacilityPPEId(int facilityId, int ppeId) {
		super();
		this.facilityId = facilityId;
		this.ppeId = ppeId;
	}

	//GETTERS N SETTERS
	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getPpeId() {
		return ppeId;
	}

	public void setPpeId(int ppeId) {
		this.ppeId = ppeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facilityId;
		result = prime * result + ppeId;
		return result;
	}

	//HASHCODE & EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilityPPEId other = (FacilityPPEId) obj;
		if (facilityId != other.facilityId)
			return false;
		if (ppeId != other.ppeId)
			return false;
		return true;
	}

	//TOSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityPPEId [facilityId=");
		builder.append(facilityId);
		builder.append(", ppeId=");
		builder.append(ppeId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
		
}
