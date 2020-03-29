package com.pandemicsupply.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Boolean icu;
	@Column(name = "negative_pressure")
	private Boolean negativePressure;
	
	@OneToMany(mappedBy = "room")
	@JsonIgnore
	private List<FacilityRoom> roomInventories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIcu() {
		return icu;
	}

	public void setIcu(Boolean icu) {
		this.icu = icu;
	}

	public Boolean getNegativePressure() {
		return negativePressure;
	}

	public void setNegativePressure(Boolean negativePressure) {
		this.negativePressure = negativePressure;
	}

	public List<FacilityRoom> getRoomInventories() {
		return roomInventories;
	}

	public void setRoomInventories(List<FacilityRoom> roomInventories) {
		this.roomInventories = roomInventories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((icu == null) ? 0 : icu.hashCode());
		result = prime * result + id;
		result = prime * result + ((negativePressure == null) ? 0 : negativePressure.hashCode());
		result = prime * result + ((roomInventories == null) ? 0 : roomInventories.hashCode());
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
		Room other = (Room) obj;
		if (icu == null) {
			if (other.icu != null)
				return false;
		} else if (!icu.equals(other.icu))
			return false;
		if (id != other.id)
			return false;
		if (negativePressure == null) {
			if (other.negativePressure != null)
				return false;
		} else if (!negativePressure.equals(other.negativePressure))
			return false;
		if (roomInventories == null) {
			if (other.roomInventories != null)
				return false;
		} else if (!roomInventories.equals(other.roomInventories))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [id=");
		builder.append(id);
		builder.append(", icu=");
		builder.append(icu);
		builder.append(", negativePressure=");
		builder.append(negativePressure);
		builder.append(", roomInventories=");
		builder.append(roomInventories);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
