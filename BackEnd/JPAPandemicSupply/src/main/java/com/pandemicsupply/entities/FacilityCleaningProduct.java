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
	private FacilityCleaningProductId id = new FacilityCleaningProductId();
	
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	@MapsId(value = "facilityId")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "cleaning_product_id")
	@MapsId(value = "cleaningProductId")
	private CleaningProduct cleaningProduct;
	
	public FacilityCleaningProduct() {}
	
	public FacilityCleaningProduct(FacilityCleaningProductId id) {
		super();
		this.id = id;
	}

	public FacilityCleaningProduct(FacilityCleaningProductId id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	
	public FacilityCleaningProduct(Facility facility, CleaningProduct cleaningProduct) {
		super();
		this.facility = facility;
		this.cleaningProduct = cleaningProduct;
	}
	
	public FacilityCleaningProduct(Facility facility, CleaningProduct cleaningProduct, int quantity) {
		super();
		this.facility = facility;
		this.cleaningProduct = cleaningProduct;
		setQuantity(quantity);
	}

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
		// quantity should only be greater than 0, pass in amount to change inventory (+ or -)
		this.quantity += quantity;
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public CleaningProduct getCleaningProduct() {
		return cleaningProduct;
	}

	public void setCleaningProduct(CleaningProduct cleaningProduct) {
		this.cleaningProduct = cleaningProduct;
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
		builder.append("\nCleaning product name: " + cleaningProduct.getName());
		return builder.toString();
	}
	
	

}
