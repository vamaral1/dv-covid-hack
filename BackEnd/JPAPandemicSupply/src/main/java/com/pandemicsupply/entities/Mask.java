package com.pandemicsupply.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Boolean improvised;
	private String name;
	private String rating;
	private Boolean reusable;
	private String type;
	private String UPC;
	
	
	@OneToMany(mappedBy = "mask")
	@JsonIgnore
	private List<FacilityMask> masks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getImprovised() {
		return improvised;
	}

	public void setImprovised(Boolean improvised) {
		this.improvised = improvised;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Boolean getReusable() {
		return reusable;
	}

	public void setReusable(Boolean reusable) {
		this.reusable = reusable;
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

	public List<FacilityMask> getMasks() {
		return masks;
	}

	public void setMasks(List<FacilityMask> masks) {
		this.masks = masks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UPC == null) ? 0 : UPC.hashCode());
		result = prime * result + id;
		result = prime * result + ((improvised == null) ? 0 : improvised.hashCode());
		result = prime * result + ((masks == null) ? 0 : masks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((reusable == null) ? 0 : reusable.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Mask other = (Mask) obj;
		if (UPC == null) {
			if (other.UPC != null)
				return false;
		} else if (!UPC.equals(other.UPC))
			return false;
		if (id != other.id)
			return false;
		if (improvised == null) {
			if (other.improvised != null)
				return false;
		} else if (!improvised.equals(other.improvised))
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
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (reusable == null) {
			if (other.reusable != null)
				return false;
		} else if (!reusable.equals(other.reusable))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mask [id=");
		builder.append(id);
		builder.append(", improvised=");
		builder.append(improvised);
		builder.append(", name=");
		builder.append(name);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", reusable=");
		builder.append(reusable);
		builder.append(", type=");
		builder.append(type);
		builder.append(", UPC=");
		builder.append(UPC);
		return builder.toString();
	}
	
	
	
	
}
