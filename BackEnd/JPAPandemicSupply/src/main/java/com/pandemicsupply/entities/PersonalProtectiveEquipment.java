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
@Table(name = "personal_protective_equipment")
public class PersonalProtectiveEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private boolean improvised;
	private boolean powdered;
	private boolean reusable;
	private Size size;
	private String type;
	private String UPC;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ppe")
	private List<FacilityPPE> ppeInventory;

	public PersonalProtectiveEquipment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isImprovised() {
		return improvised;
	}

	public void setImprovised(boolean improvised) {
		this.improvised = improvised;
	}

	public boolean isPowdered() {
		return powdered;
	}

	public void setPowdered(boolean powdered) {
		this.powdered = powdered;
	}

	public boolean isReusable() {
		return reusable;
	}

	public void setReusable(boolean reusable) {
		this.reusable = reusable;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public List<FacilityPPE> getPpeInventory() {
		return ppeInventory;
	}

	public void setPpeInventory(List<FacilityPPE> ppeInventory) {
		this.ppeInventory = ppeInventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PersonalProtectiveEquipment other = (PersonalProtectiveEquipment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalProtectiveEquipment [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", improvised=");
		builder.append(improvised);
		builder.append(", powdered=");
		builder.append(powdered);
		builder.append(", reusable=");
		builder.append(reusable);
		builder.append(", size=");
		builder.append(size);
		builder.append(", type=");
		builder.append(type);
		builder.append(", UPC=");
		builder.append(UPC);
		builder.append(", ppeInventory=");
		builder.append(ppeInventory);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	

}
