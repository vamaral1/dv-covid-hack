package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "facility_ventilator")
public class FacilityVentilator {
	
	@EmbeddedId
	private FacilityVentilatorId id = new FacilityVentilatorId();
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "ventilator_id")
	@MapsId(value = "ventId")
	private Ventilator ventilator;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;

	//ctors
	public FacilityVentilator() {
		super();
	}

	public FacilityVentilator(FacilityVentilatorId id) {
		super();
		this.id = id;
	}

	public FacilityVentilator(FacilityVentilatorId id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public FacilityVentilator(Ventilator ventilator, Facility facility) {
		super();
		this.ventilator = ventilator;
		this.facility = facility;
	}

	public FacilityVentilator(int quantity, Ventilator ventilator, Facility facility) {
		super();
		setQuantity(quantity);
		this.ventilator = ventilator;
		this.facility = facility;
	}

	public FacilityVentilatorId getId() {
		return id;
	}

	public void setId(FacilityVentilatorId id) {
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

	public Ventilator getVentilator() {
		return ventilator;
	}

	public void setVentilator(Ventilator ventilator) {
		this.ventilator = ventilator;
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
		FacilityVentilator other = (FacilityVentilator) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FacilityVentilator [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", ventilator=");
		builder.append(ventilator);
		builder.append(", facility=");
		builder.append(facility);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	


}
