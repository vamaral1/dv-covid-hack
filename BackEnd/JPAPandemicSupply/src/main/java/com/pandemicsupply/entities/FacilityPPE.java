package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "facility_ppe")
public class FacilityPPE {

	@EmbeddedId
	private FacilityPPEId id = new FacilityPPEId();

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "ppe_id")
	@MapsId(value = "ppeId")
	private PersonalProtectiveEquipment ppe;

	@JsonIgnoreProperties({"facilityCleaningProducts", "masks", "ventilators", "ppes", "tests"})
	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;

	//ctors
	public FacilityPPE() {
		super();
	}

	public FacilityPPE(FacilityPPEId id) {
		super();
		this.id = id;
	}

	public FacilityPPE(FacilityPPEId id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public FacilityPPE(Facility facility, PersonalProtectiveEquipment ppe) {
		super();
		this.facility = facility;
		this.ppe = ppe;
	}

	public FacilityPPE(Facility facility, PersonalProtectiveEquipment ppe, int quantity) {
		super();
		this.facility = facility;
		this.ppe = ppe;
		setQuantity(quantity);
	}

	public FacilityPPEId getId() {
		return id;
	}

	//getters and setters
	public void setId(FacilityPPEId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		// quantity should only be greater than 0, pass in amount to change inventory (+ or -)
		this.quantity += quantity;
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public PersonalProtectiveEquipment getPpe() {
		return ppe;
	}

	public void setPpe(PersonalProtectiveEquipment ppe) {
		this.ppe = ppe;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FacilityPPE other = (FacilityPPE) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityPPE [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		builder.append("\nPPE name: " + ppe.getName());
		return builder.toString();
	}
	
	
	

	
}
