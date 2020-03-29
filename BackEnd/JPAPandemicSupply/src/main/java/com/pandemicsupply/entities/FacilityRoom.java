package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facility_room")
public class FacilityRoom {
	
	@EmbeddedId
	private FacilityRoomId id = new FacilityRoomId();
	
	private int quantity;
	
	@JsonIgnoreProperties({"facilityCleaningProducts", "masks", "facilityRoomsInventory", "ventilators", "ppes"})
	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	@MapsId(value = "roomId")
	private Room room;
	
	public FacilityRoom() {}

	public FacilityRoom(Facility facility, Room room) {
		super();
		this.facility = facility;
		this.room = room;
	}

	public FacilityRoom(int quantity, Facility facility, Room room) {
		super();
		this.quantity = quantity;
		this.facility = facility;
		this.room = room;
	}

	public FacilityRoomId getId() {
		return id;
	}

	public void setId(FacilityRoomId id) {
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facility == null) ? 0 : facility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		FacilityRoom other = (FacilityRoom) obj;
		if (facility == null) {
			if (other.facility != null)
				return false;
		} else if (!facility.equals(other.facility))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity != other.quantity)
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityRoom [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", facility=");
		builder.append(facility);
		builder.append(", room=");
		builder.append(room);
		builder.append("]");
		return builder.toString();
	}
	
	

}
