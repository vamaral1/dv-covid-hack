package com.pandemicsupply.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "address_id")
	private int addressId;
	private String name;
	
	@OneToMany(mappedBy = "facility")
	private List<FacilityCleaningProduct> facilityCleaningProducts;
	
	@OneToMany(mappedBy = "facility")
	private List<FacilityMask> masks;
	
	@OneToMany(mappedBy = "facility")
	private List<FacilityVentilator> ventilators;
	
	@OneToMany(mappedBy = "facility")
	private List<FacilityPPE> ppes;
	
	public List<FacilityVentilator> getVentilators() {
		return ventilators;
	}
	public void setVentilators(List<FacilityVentilator> ventilators) {
		this.ventilators = ventilators;
	}
	public List<FacilityPPE> getPpes() {
		return ppes;
	}
	public void setPpes(List<FacilityPPE> ppes) {
		this.ppes = ppes;
	}
	public List<FacilityMask> getMasks() {
		return masks;
	}
	public void setMasks(List<FacilityMask> masks) {
		this.masks = masks;
	}
	public List<FacilityCleaningProduct> getFacilityCleaningProducts() {
		return facilityCleaningProducts;
	}
	public void setFacilityCleaningProducts(List<FacilityCleaningProduct> facilityCleaningProducts) {
		this.facilityCleaningProducts = facilityCleaningProducts;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((facilityCleaningProducts == null) ? 0 : facilityCleaningProducts.hashCode());
		result = prime * result + id;
		result = prime * result + ((masks == null) ? 0 : masks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Facility other = (Facility) obj;
		if (addressId != other.addressId)
			return false;
		if (facilityCleaningProducts == null) {
			if (other.facilityCleaningProducts != null)
				return false;
		} else if (!facilityCleaningProducts.equals(other.facilityCleaningProducts))
			return false;
		if (id != other.id)
			return false;
		if (masks == null) {
			if (other.masks != null)
				return false;
		} else if (!masks.equals(other.masks))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Facility [id=");
		builder.append(id);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", facilityCleaningProducts=");
		builder.append(facilityCleaningProducts);
		builder.append(", masks=");
		builder.append(masks);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
