package com.pandemicsupply.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cleaning_product")
public class CleaningProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String agent;
	private Double concentration;
	private String name;
	private Double volume;
	private String UPC;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cleaningProduct")
	private List<FacilityCleaningProduct> facilityCleaningProducts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Double getConcentration() {
		return concentration;
	}

	public void setConcentration(Double concentration) {
		this.concentration = concentration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public List<FacilityCleaningProduct> getFacilityCleaningProducts() {
		return facilityCleaningProducts;
	}

	public void setFacilityCleaningProducts(List<FacilityCleaningProduct> facilityCleaningProducts) {
		this.facilityCleaningProducts = facilityCleaningProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UPC == null) ? 0 : UPC.hashCode());
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		result = prime * result + ((concentration == null) ? 0 : concentration.hashCode());
		result = prime * result + ((facilityCleaningProducts == null) ? 0 : facilityCleaningProducts.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		CleaningProduct other = (CleaningProduct) obj;
		if (UPC == null) {
			if (other.UPC != null)
				return false;
		} else if (!UPC.equals(other.UPC))
			return false;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (concentration == null) {
			if (other.concentration != null)
				return false;
		} else if (!concentration.equals(other.concentration))
			return false;
		if (facilityCleaningProducts == null) {
			if (other.facilityCleaningProducts != null)
				return false;
		} else if (!facilityCleaningProducts.equals(other.facilityCleaningProducts))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CleaningProduct [id=");
		builder.append(id);
		builder.append(", agent=");
		builder.append(agent);
		builder.append(", concentration=");
		builder.append(concentration);
		builder.append(", name=");
		builder.append(name);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", UPC=");
		builder.append(UPC);
		return builder.toString();
	}
	
	
	

}
