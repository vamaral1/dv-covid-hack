package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityVentilatorId implements Serializable {
	private static final long serialVersionUID = 1L;

	//fields
	@Column(name = "facility_id")
	private int facilityId;

	@Column(name = "ventilator_id")
	private int ventilatorId;

	//ctors
	public FacilityVentilatorId() {
		super();
	}

	public FacilityVentilatorId(int facilityId, int ventilatorId) {
		super();
		this.facilityId = facilityId;
		this.ventilatorId = ventilatorId;
	}

	//get n set
	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getVentilatorId() {
		return ventilatorId;
	}

	public void setVentilatorId(int ventilatorId) {
		this.ventilatorId = ventilatorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facilityId;
		result = prime * result + ventilatorId;
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
		FacilityVentilatorId other = (FacilityVentilatorId) obj;
		if (facilityId != other.facilityId)
			return false;
		if (ventilatorId != other.ventilatorId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityVentilatorId [facilityId=");
		builder.append(facilityId);
		builder.append(", ventilatorId=");
		builder.append(ventilatorId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
