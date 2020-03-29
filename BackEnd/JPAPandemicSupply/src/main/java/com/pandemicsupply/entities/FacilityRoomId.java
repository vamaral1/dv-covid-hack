package com.pandemicsupply.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacilityRoomId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "facility_id")
	private int facilityId;

	@Column(name = "room_id")
	private int roomId;

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facilityId;
		result = prime * result + roomId;
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
		FacilityRoomId other = (FacilityRoomId) obj;
		if (facilityId != other.facilityId)
			return false;
		if (roomId != other.roomId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityRoomId [facilityId=");
		builder.append(facilityId);
		builder.append(", roomId=");
		builder.append(roomId);
		builder.append("]");
		return builder.toString();
	}
	
	
}
