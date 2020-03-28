package com.pandemicsupply.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "facility_cleaning_product")
public class FacilityCleaningProduct {
	
	@EmbeddedId
	private FacilityCleaningProductId id;
	
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "cleaning_product_id")
	@MapsId(value = "cleaningProductId")
	private CleaningProduct cleaningProduct;
	
	public FacilityCleaningProductId getId() {
		return id;
	}

	public void setId(FacilityCleaningProductId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		FacilityCleaningProduct other = (FacilityCleaningProduct) obj;
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
		builder.append("FacilityCleaningProduct [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
	

}
