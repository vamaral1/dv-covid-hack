package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facility_mask")
public class FacilityMask {
	
	@EmbeddedId
	private FacilityMaskId id = new FacilityMaskId();
	
	private int quantity;
	
	@JsonIgnoreProperties({"facilityCleaningProducts", "masks"})
	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "mask_id")
	@MapsId(value = "maskId")
	private Mask mask;
	
	public FacilityMask() {}
	
	public FacilityMask(int quantity, Facility facility, Mask mask) {
		super();
		this.quantity = quantity;
		this.facility = facility;
		this.mask = mask;
	}

	public FacilityMask(Facility facility, Mask mask) {
		super();
		this.facility = facility;
		this.mask = mask;
	}

	public FacilityMaskId getId() {
		return id;
	}

	public void setId(FacilityMaskId id) {
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

	public Mask getMask() {
		return mask;
	}

	public void setMask(Mask mask) {
		this.mask = mask;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facility == null) ? 0 : facility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mask == null) ? 0 : mask.hashCode());
		result = prime * result + quantity;
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
		FacilityMask other = (FacilityMask) obj;
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
		if (mask == null) {
			if (other.mask != null)
				return false;
		} else if (!mask.equals(other.mask))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityMask [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("\nMask: " +mask.getName());
		return builder.toString();
	}
	
	
	
}
